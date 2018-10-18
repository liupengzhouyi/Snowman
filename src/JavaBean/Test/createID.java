package JavaBean.Test;
import JavaBean.Tools.*;


public class createID {

    public createID(String provice, String number) {
        String ID = null;
        //省份： 内蒙古自治区
        //第几个： 56
        //获取日期
        String date = new getNowTime().getUsedStringForID();
        ID = date;

        //获取省份
        ID = new GetProviceNumber().getID(ID, provice);

        //获取number
        AddNumber addNumber = new AddNumber(ID);

        addNumber.init(number);

        ID = addNumber.getID();

        //性别
        ID = new AddSexNumber(ID, "男").getIDNumber();

        //校验
        ID = new VerifyCode(ID).getID();

        //System.out.println(ID);

        this.setID(ID);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    private String ID = null;

    public static void main(String[] args) {
        new createID("内蒙古自治区", "56");
    }
}
