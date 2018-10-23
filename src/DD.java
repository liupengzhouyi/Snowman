public class DD {

    public void getdiStricts() {
        String string = "昆都仑区,东河区,青山区,石拐区,白云鄂博矿区,九原区,固阳县,土默特右旗,达尔罕茂明安联合旗";
        String[] strings = string.split(",");
        for (int i=0;i<strings.length;i++) {
            System.out.println("INSERT INTO new_database.dbo.tb_districts_table (county_number, name_of_counties) VALUES (" + i + ",\'" + strings[i] + "\');");
        }
    }


    public void getUser() {
        String string = "王帅霖\t15540250617\n" +
                "贝伟富\t18718991930\n" +
                "石昌青\t13224873411\n" +
                "刘晓慧\t13674871479\n" +
                "王鹏\t15849470743\n" +
                "任鸿飞\t15849479152\n" +
                "孟庆宁\t13224851023\n" +
                "王杨\t13284710904\n" +
                "陈杰\t13224712134\n" +
                "马国俊\t13224871238\n" +
                "郝夙瑶\t15540256397\n" +
                "秦宇航\t15661392213\n" +
                "董旺\t13224717163\n" +
                "张冲\t15248560925\n" +
                "孙海博\t15991367032\n" +
                "蒋利智\t13224871354\n" +
                "张国强\t15848676760\n" +
                "卢志皓\t15849478466\n" +
                "曹宝宝\t15849465079\n" +
                "刘鹏\t15048443876\n" +
                "白雄\t14747272897\n" +
                "邓浩均\t15849476712\n" +
                "刘源\t13224724635\n" +
                "李国强\t15849475904\n" +
                "郭威\t13224858536\n" +
                "李荣京\t17614820740\n" +
                "卢良臣\t18586165452\n" +
                "王维坤\t13224859533\n" +
                "王晓宇\t15247468059\n" +
                "郎海霞\t15848672258\n" +
                "赵东旭\t18547276414\n" +
                "王悦琦\t17604893590\n" +
                "龚倩\t15661663018\n" +
                "戴祥\t13224710933\n" +
                "黄鑫烨\t13511710924\n" +
                "高家奇\t18586100016\n" +
                "王晓晖\t13224858382\n" +
                "白晓龙\t13224722245\n" +
                "李松吉\t13224869432\n" +
                "高伟\t15661666339\n" +
                "张小旭\t13642094644\n" +
                "董广跃\t15848663411\n" +
                "周齐\t15661561240\n" +
                "贾翔宇\t15548125401\n" +
                "卢宏铭\t13224714389\n" +
                "郭之曦\t15849745140\n";
        String[] strings = string.split("\n");
        int number = strings.length;
        int j=0;
        for (int i=46;i<2000;i++) {
            String[] str = strings[j].split("\t");
            String strI = str[0];
            String strII = str[1];
            j++;
            if (j == 45) {
                j = 0;
            }
            System.out.println("INSERT INTO new_database.dbo.tb_customer_table" +
                    "(customer_number, customer_name, customer_password, " +
                    "customer_registration_date, customer_contact_information) " +
                    "VALUES (" + i + ", \'" + strI + "\', \'" + strII + "\', " + "GEtDATE(), \'" + strII + "\');");
        }
    }

    public void getStreet() {
        String string = "少先路街道\t1\n" +
                "沼潭街道\t1\n" +
                "林荫路街道\t1\n" +
                "友谊大街街道\t1\n" +
                "阿尔丁大街街道\t1\n" +
                "富强路街道\t2\n" +
                "幸福路街道\t2\n" +
                "青山路街道\t2\n" +
                "自由路街道\t2\n" +
                "万青路街道\t2\n" +
                "铁西街道\t3\n" +
                "西脑包街道\t3\n" +
                "财神庙街道\t3\n" +
                "东站街道\t3\n" +
                "沙河街道\t4\n" +
                "赛汉街道\t4\n" +
                "萨如拉街道\t4\n" +
                "石拐街道\t5\n" +
                "大发街道\t5\n" +
                "通阳路街道\t6\n" +
                "矿山路街道\t6";
        String[] strings = string.split("\n");
        for (int i=0;i<21;i++) {
            //System.out.println(strings[i]);
            String[] str = strings[i].split("\t");
            String strI = str[0];
            String strII = str[1];

            System.out.println("INSERT INTO new_database.dbo.tb_street_table " +
                    "(street_number, street_name, county_number) " +
                    "VALUES (" + i + ", \'" + strI + "\', \'" + strII + "\')");

        }
    }

    public static void main(String[] args) {
        new DD().getdiStricts();
    }
}
