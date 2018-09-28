package JavaBean.linkDatabase;

public class getSQLString {

    public String getSql1() {
        return sql1;
    }

    public void setSql1(String date, String time) {
        //String string = "insert into lp_sleep_table(lp_id, lp_date, lp_time1) value (3, \'" + date + "\', \'" + time + "\');";
        String string = "insert into lp_sleep_table(lp_date, lp_time1) value (\'" + date + "\', \'" + time + "\');";
        this.sql1 = string;
        System.out.print(string);
    }

    public String getSql2() {
        return sql2;
    }

    public void setSql2(String date, String time) {
        String string = "update lp_sleep_table set lp_time2 = \'" + time + "\' where lp_date = \'" + date + "\';";
        this.sql2 = string;
        this.sql2 = sql2;
    }

    public String getSql3() {
        return sql3;
    }

    public void setSql3(String date, String time) {
        String string = "update lp_sleep_table set lp_time3 = \'" + time + "\' where lp_date = \'" + date + "\';";
        this.sql3 = string;
        this.sql3 = sql3;
    }

    public String getSql4() {
        return sql4;
    }

    public void setSql4(String date, String time) {
        String string = "update lp_sleep_table set lp_time4 = \'" + time + "\' where lp_date = \'" + date + "\';";
        this.sql4 = string;
    }

    public String getSql5() {
        return sql5;
    }

    public void setSql5(String date, String number) {
        String sql = "insert into lp_learn_english_table(lp_date, lp_word) value (\'" + date + "\', " + number + ");";
        this.sql5 = sql;
    }


    public String getSql6() {
        return sql6;
    }

    public void setSql6(String date, String number) {
        String sql = "update lp_learn_english_table set lp_reading = \'" + number + "\' where lp_date = \'" + date + "\';";
        this.sql6 = sql;
    }

    public String getSql7() {
        return sql7;
    }

    public void setSql7(String date, String name, String url, String number) {
        //String sql = "insert into lp_blogs_table (lp_id, lp_date, lp_time, lp_name, lp_url) value (1, '2018-09-27', 1, 'qwe', '234');";
        String sql = "insert into lp_blogs_table (lp_date, lp_time, lp_name, lp_url) value (\'" + date + "\', " + number + ", \'" + name + "\', \'" + url + "\');";
        this.sql7 = sql;
    }

    public String getSql8() {
        return sql8;
    }

    public void setSql8(String date, String name, String url, String number) {
        String sql = "insert into lp_github_table (lp_id, lp_date, lp_time, lp_name, lp_url) value (1, \'" + date + "\', 1, \'" + name + "\', \'" + url + "\');";
        //String sql = "insert into lp_github_table (lp_date, lp_time, lp_name, lp_url) value (\'" + date + "\', " + number + ", \'" + name + "\', \'" + url + "\');";
        this.sql8 = sql;
    }

    public String getSql10() {
        return sql10;
    }

    public void setSql10(String account_class) {
        //String string = "insert into lp_account_class_table(lp_id, lp_name) value (1, '早餐');";
        String sql = "insert into lp_account_class_table(lp_name) value (\'" + account_class + "\');";
        System.out.print(sql);
        this.sql10 = sql;
    }

    public String getSqlForGetclass() {
        return sqlForGetclass;
    }

    public void setSqlForGetclass() {
        this.sqlForGetclass = "select * from lp_account_class_table;";
    }

    private String sql1;
    private String sql2;
    private String sql3;
    private String sql4;
    private String sql5;
    private String sql6;
    private String sql7;
    private String sql8;
    private String sql10;
    private String sqlForGetclass;
}
