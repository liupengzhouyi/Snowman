package JavaBean.Tools.Password;

import java.lang.reflect.Array;

public class password {

    //构造函数
    //参数：邮箱地址
    //liupeng.0@outlook.com
    public password(String publicPassword) {
        this.publicPassword = publicPassword;
        this.privatePassword = "";
        this.makePrivaetPassword();
    }

    //制作私钥
    public void makePrivaetPassword() {
        //公钥字符串转化成char数组
        char[] arrays = this.getPublicPassword().toCharArray();
        int longth = arrays.length;

        //算出密钥
        int tempNumber = 0;
        String tempString = "";
        for (int i=0;i<longth; i++) {
            tempNumber = this.CharToInt(arrays[i]);
            tempString = this.IntToString(tempNumber);
            this.setPrivatePassword(this.getPrivatePassword() + tempString);
        }

        longth = this.getPrivatePassword().length();
        arrays = this.getPrivatePassword().toCharArray();
        this.setPrivatePassword("");
        for (int i=0;i<longth;i=i+5) {
            tempString = this.CharToString(arrays[i]);
            this.setPrivatePassword(this.getPrivatePassword() + tempString);
        }

        //确定密钥长度
        int number = 12;
        longth = this.getPrivatePassword().length();
        if (longth != number) {
            if (longth < number) {
                int num = number - longth;
                for (int i=0;i<num;i++) {
                    this.setPrivatePassword(this.getPrivatePassword() + "0");
                }
            } else {
                this.setPrivatePassword(this.getPrivatePassword().substring(0,number));
            }
        }
    }

    public void TestForPrintPrivatePassword() {
        System.out.print(this.getPrivatePassword());
    }

    //char 转 int 小工具
    public int CharToInt(char c) {
        int number = -1;
        number = (int)c;
        return number;
    }

    //int 转 String 小工具
    public String IntToString(int number) {
        String string = "" + number;
        return string;
    }

    //char转String 小工具
    public String CharToString(char c) {
        String string = "" + c;
        return string;
    }

    //公钥
    private String publicPassword = null;
    //私钥
    private String privatePassword = null;

    public String getPublicPassword() {
        return publicPassword;
    }

    public void setPublicPassword(String publicPassword) {
        this.publicPassword = publicPassword;
    }

    public String getPrivatePassword() {
        return privatePassword;
    }

    public void setPrivatePassword(String privatePassword) {
        this.privatePassword = privatePassword;
    }

    public static void main(String[] args) {
        new password("liupeng.0@outlook.com").TestForPrintPrivatePassword();
    }
}