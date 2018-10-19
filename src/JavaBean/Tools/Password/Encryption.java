package JavaBean.Tools.Password;

import java.lang.reflect.Array;


// Integer.toHexString();//转码
// Integer.parseInt();//解码

public class Encryption {

    //构造函数
    public Encryption(String plainText) {
        this.plainText = plainText;
        this.init();
        this.createText();
    }

    public void test() {
        String s = "核心价值观";

        DIYCode diyCode = new DIYCode();
        String code = diyCode.unicode(s);
        System.out.println(code);
        System.out.println(diyCode.decodeUnicode(code));

    }

    public void createText() {
        String value = "";
        String key = "";
        int longth = this.getPlainText().length();
        //System.out.println(longth);
        char[] arrays = this.getPlainText().toCharArray();
        for (int i=0;i<longth;i++) {
            key = arrays[i] + "";
            value = this.getAddCoreValues().getValue(key);
            //System.out.println(key + ":" + value);
            this.setText(this.getText() + value);
        }
    }

    public void init() {
        this.createAddCoreValues();
        this.setText("");
    }


    //私钥
    private String publicPassword = null;
    //明文
    private String plainText = null;
    //密文
    private String text = null;
    //密码工具
    private AddCoreValues addCoreValues = null;

    public String getPublicPassword() {
        return publicPassword;
    }

    public void setPublicPassword(String publicPassword) {
        this.publicPassword = publicPassword;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public AddCoreValues getAddCoreValues() {
        return addCoreValues;
    }

    public void setAddCoreValues(AddCoreValues addCoreValues) {
        this.addCoreValues = addCoreValues;
    }

    public void createAddCoreValues() {
        this.setAddCoreValues(new AddCoreValues());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public static void main(String[] args) {
        Encryption encryption = new Encryption("u16838u55c102ec99e3u14c101ec102e7u1503c99eu389c99e2");
        System.out.println(encryption.getText());
    }
}