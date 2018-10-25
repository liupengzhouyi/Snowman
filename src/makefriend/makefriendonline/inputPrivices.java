package makefriend.makefriendonline;

import java.sql.SQLException;

public class inputPrivices {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        linkDatabases lpLinkDatabases = new linkDatabases();

        String[] provices = {
                "北京市",
                "天津市",
                "上海市",
                "重庆市",
                "河北省",
                "山西省",
                "辽宁省",
                "吉林省",
                "黑龙江省",
                "江苏省",
                "浙江省",
                "安徽省",
                "福建省",
                "江西省",
                "山东省",
                "河南省",
                "湖北省",
                "湖南省",
                "广东省",
                "海南省",
                "四川省",
                "贵州省",
                "云南省",
                "陕西省",
                "甘肃省",
                "青海省",
                "台湾省",
                "内蒙古自治区",
                "广西壮族自治区",
                "西藏自治区",
                "宁夏回族自治区",
                "新疆维吾尔自治区",
                "香港特别行政区",
                "澳门特别行政区"
        };

        for (int i=0;i<provices.length;i++) {
            String sql = "insert into privince_table(provices_id, provices_name) values (" + i + ", \'" + provices[i] + "\'" + ");";
            //lpLinkDatabases.saveData(sql);
        }

        new inputPrivices().getPrivinceNumber();

    }

    public void getPrivinceNumber() {
        String string = "0\t18-10-25\t0\n" +
                "1\t18-10-25\t0\n" +
                "2\t18-10-25\t0\n" +
                "3\t18-10-25\t0\n" +
                "4\t18-10-25\t0\n" +
                "5\t18-10-25\t0\n" +
                "6\t18-10-25\t0\n" +
                "7\t18-10-25\t0\n" +
                "8\t18-10-25\t0\n" +
                "9\t18-10-25\t0\n" +
                "10\t18-10-25\t0\n" +
                "11\t18-10-25\t0\n" +
                "12\t18-10-25\t0\n" +
                "13\t18-10-25\t0\n" +
                "14\t18-10-25\t0\n" +
                "15\t18-10-25\t0\n" +
                "16\t18-10-25\t0\n" +
                "17\t18-10-25\t0\n" +
                "18\t18-10-25\t0\n" +
                "19\t18-10-25\t0\n" +
                "20\t18-10-25\t0\n" +
                "21\t18-10-25\t0\n" +
                "22\t18-10-25\t0\n" +
                "23\t18-10-25\t0\n" +
                "24\t18-10-25\t0\n" +
                "25\t18-10-25\t0\n" +
                "26\t18-10-25\t0\n" +
                "27\t18-10-25\t0\n" +
                "28\t18-10-25\t0\n" +
                "29\t18-10-25\t0\n" +
                "30\t18-10-25\t0\n" +
                "31\t18-10-25\t0\n" +
                "32\t18-10-25\t0\n" +
                "33\t18-10-25\t0\n";

        String[] strings = string.split("\n");
        for (int i=0;i<strings.length;i++) {
            String[] values = strings[i].split("\t");
            System.out.println("insert into privince_number_table" +
                    "(privince_id, today, number) values " +
                    "(" + values[0] + ", \'20" + values[1] + "\', " + values[2] + ");");
        }

    }

}
