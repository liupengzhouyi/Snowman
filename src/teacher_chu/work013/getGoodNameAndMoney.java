package teacher_chu.work013;

import JavaBean.linkDatabase.linkDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getGoodNameAndMoney {

    public getGoodNameAndMoney(String good_id) throws ClassNotFoundException, SQLException {
        this.init();
        this.good_id = good_id;
        this.setSql(good_id);
        linkDatabases lpLinkDatabases = new linkDatabases();
        ResultSet resultSet = lpLinkDatabases.getInformation(this.getSql());
        while (resultSet.next()) {
            this.setGood_name(resultSet.getString("good_name"));
            this.setMoney(resultSet.getInt("good_prich"));
        }
    }

    public void init() {
        this.good_id = new String();
        this.good_name = new String();
        this.sql = new String();
    }

    private String sql = "";
    private String good_id = null;
    private String good_name = null;
    private int money = 0;

    public String getGood_id() {
        return good_id;
    }


    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String good_id) {
        this.sql = "select * from lp_goods_for_java_web where good_id = " + good_id + ";";
    }
}
