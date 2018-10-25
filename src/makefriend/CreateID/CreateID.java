package makefriend.CreateID;

import makefriend.makefriendonline.linkDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateID {
    /**
     * 需要参数：省份
     * 需要性别
     *
     */
    public CreateID(String provice, String sex) throws SQLException, ClassNotFoundException {
        this.init(provice);

        String ID = null;
        //省份： 内蒙古自治区
        //第几个： 56
        //获取日期
        String date = new getNowTime().getUsedStringForID();
        ID = date;

        //获取省份
        ID = new GetProviceNumber().getID(ID, provice);

        //获取number
        AddNumber addNumber = new AddNumber(ID,number);

        addNumber.init(number);

        ID = addNumber.getID();

        //性别
        ID = new AddSexNumber(ID, sex).getIDNumber();

        //校验
        ID = new VerifyCode(ID).getID();

        System.out.println(ID);

        this.setID(ID);
    }

    public void init(String provice) throws ClassNotFoundException, SQLException {
        number = new String();
        sex = new String();
        String sql = "select provices_id from privince_table where provices_name = \'" + provice + "\';";
        System.out.println(sql);
        ResultSet resultSet = new linkDatabases().getInformation(sql);
        int proviceId = -1;
        String dateInDB = "";
        int number = -1;
        while(resultSet.next()) {
            proviceId = resultSet.getInt("provices_id");
        }
        System.out.println(proviceId);
        String date = new getNowTime().getDate();
        sql = "select * from privince_number_table where privince_id = " + proviceId + ";";
        resultSet = new linkDatabases().getInformation(sql);
        while(resultSet.next()) {
            dateInDB = resultSet.getString("today");
            number = resultSet.getInt("number");
            break;
        }
        System.out.println(date);
        System.out.println(dateInDB);
        if (date.equals(dateInDB)) {
            number = number + 1;
        } else {
            System.out.println("-----");
            dateInDB = date;
            number = 0;
            this.setNumber(number);
        }
        this.setNumber(number);
        sql = "update privince_number_table set today = \'" + dateInDB + "\', number = " + number + " where privince_id = " + proviceId + ";";
        System.out.println(sql);
        new linkDatabases().updateData(sql);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number + "";
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    private String ID = null;

    private String number = null;

    private String sex = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new CreateID("内蒙古自治区", "男");
    }

}
