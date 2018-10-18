package JavaBean.Tools;

/**
 * 函数调用过程
 * 1。 实例话 需要参数 ID ：date + proviceNumber
 * 2。 class.init(参数) ：当前在数据库中，今天该省份的注册人数
 * 3。 String getID(); :获取ID
 */

public class AddNumber {

    public AddNumber(String ID) {
        this.setID(ID);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    //初始化函数
    public void init(String number) {
        int num = StringToInt(number);
        number = String.valueOf(num);
        number = ReturnThreeNumber(number);
        this.ID = this.ID + number;
    }

    //传入一个三位的数字字符串 001
    // 确保参数 < 998
    public int StringToInt(String number) {
        int num = Integer.parseInt(number);
        if (num >= 999) {
            return -1;
        } else {
            num = num + 1;
        }
        return num;
    }

    //传入一个number String,
    // 返回一个 三位 NumberString
    public String ReturnThreeNumber(String number) {
        int longth = number.length();
        //为number补位，确保他是三位数
        if (longth == 1) {
            number = "00" + number;
        } else if(longth == 2) {
            number = "0" + number;
        } else {
            number = number;
        }
        return number;
    }

    //ID String
    private String ID = null;
    // Number String
    private String number = null;
}
