package JavaBean.linkDatabase;

public class getSQLString {

    public String getSql1() {
        return sql1;
    }

    public void setSql1(String date, String time) {
        //String string = "insert into lp_sleep_table(lp_id, lp_date, lp_time1) value (3, \'" + date + "\', \'" + time + "\');";
        String string = "insert into lp_sleep_table(lp_date, lp_time1) value (\'" + date + "\', \'" + time + "\');";
        this.sql1 = string;
        // System.out.print(string);
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
        // System.out.print(sql);
        this.sql10 = sql;
    }

    public String getSqlForGetclass() {
        return sqlForGetclass;
    }

    public void setSqlForGetclass() {
        this.sqlForGetclass = "select * from lp_account_class_table;";
    }

    public String getSql9() {
        return sql9;
    }

    public void setSql9(String datetime, String account_class, String amount, String pay, String addText) {
        // String sql = "insert into lp_consume_table(lp_id, lp_datetime, lp_account_class_id, lp_amount, lp_payments, lp_add_text) value (1, now(), 1, 21.5, 's', '');";
        String sql = "insert into lp_consume_table(lp_datetime, lp_account_class_id, lp_amount, lp_payments, lp_add_text) " +
                "value (\'" + datetime + "\'," + account_class + ", " + amount + ", \'" + pay + "\', \'" + addText + "\');";
        this.sql9 = sql;
    }

    public String getSql_sleep_table() {
        return sql_sleep_table;
    }

    public void setSql_sleep_table() {
        this.sql_sleep_table = "select * from lp_sleep_table;";
    }

    public String getSqlForWord2_1() {
        return sqlForWord2_1;
    }

    public void setSqlForWord2_1(String name, String phone, String email, String title, String content, String time ) {
        String sql = "insert into guestbook (name, phone, email, title, content, time) value " +
                "(\'" + name + "\', \'" + phone + "\', \'" + email + "\', \'" + title + "\', \'" + content + "\', \'" + time + "\');";
        this.sqlForWord2_1 = sql;
    }

    public String getSqlForWord2_2() {
        return sqlForWord2_2;
    }

    public void setSqlForWord2_2() {
        String sql = "select *from guestbook;";
        this.sqlForWord2_2 = sql;
    }

    //insert into lp_uesr_table_for_java_web (user_id, user_name, user_password) values (1, "liupeng", "123456");
    public String getSql11() {
        return sql11;
    }

    public void setSql11(String name, String password) {
        this.sql11 = "insert into lp_uesr_table_for_java_web (user_name, user_password) values (\"" + name + "\", \"" + password + "\");";
    }

    public String getSql12() {
        return sql12;
    }

    public void setSql12(String id) {
        this.sql12 = "select * from lp_uesr_table_for_java_web where user_id = " + id + ";";
    }

    public String getSql13() {
        return sql13;
    }

    public void setSql13(String name, int prich) {
        //insert into lp_goods_for_java_web (good_id, good_name, good_prich) values (1, 'iphone', 12000);
        this.sql13 = "insert into lp_goods_for_java_web (good_name, good_prich) values (\'" + name + "\', " + prich + ");";
    }

    public String getSql14() {
        return sql14;
    }

    public void setSql14() {
        this.sql14 = "select * from lp_goods_for_java_web;";
    }

    public String getSql15() {
        return sql15;
    }

    public void setSql15(String user_id) {
        this.sql15 = "select * from lp_uesr_table_for_java_web where user_id = " + user_id + ";";
    }

    public String getSql16() {
        return sql16;
    }

    public void setSql16(String good_name) {
        this.sql16 = "select * from lp_goods_for_java_web where good_name = \"" + good_name + "\";";
    }

    public String getSql17() {
        return sql17;
    }

    public void setSql17(String user_id, String good_id, String number, String book_date) {
        //insert into lp_shop_book_for_java_web (book_id, user_id, good_id, number, book_date) values (1, 1, 1, 2, now());
        this.sql17 = "insert into lp_shop_book_for_java_web (user_id, good_id, number, book_date) values (" + user_id +
                ", " + good_id + ", " + number + ", \'" + book_date + "\');";
    }

    public String getSql18() {
        return sql18;
    }

    public void setSql18(String user_id) {
        //select * from lp_shop_book_for_java_web where user_id = 1;
        this.sql18 = "select * from lp_shop_book_for_java_web where user_id = " + user_id + ";";
    }

    public String getSql19() {
        return sql19;
    }

    public void setSql19(String user_id) {
        this.sql19 = "select A.book_id as '订单号', C.user_name as '用户名', B.good_name as '商品名', " +
                "A.number as '数量', A.book_date as '订单日期' from lp_shop_book_for_java_web A, " +
                "lp_goods_for_java_web B, lp_uesr_table_for_java_web C where " +
                "(A.user_id = C.user_id and A.good_id = B.good_id) and A.user_id = " + user_id + ";";
    }

    private String sql1;
    private String sql2;
    private String sql3;
    private String sql4;
    private String sql5;
    private String sql6;
    private String sql7;
    private String sql8;
    private String sql9;
    private String sql10;
    private String sqlForGetclass;
    private String sql_sleep_table;
    private String sqlForWord2_1;
    private String sqlForWord2_2;
    private String sql11;
    private String sql12;
    private String sql13;
    private String sql14;
    private String sql15;
    private String sql16;
    private String sql17;
    private String sql18;
    private String sql19;
}
