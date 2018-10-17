package JavaBean.Tools;
import java.util.*;

public class GetProviceNumber {

    private String[] provices = {
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

    private Map <String, Object> proviceMap = null;



    public GetProviceNumber() {
        init();

    }

    public void init() {
        proviceMap = new HashMap<String, Object>();

        int provicesNumber = this.provices.length;
        int number = 0;
        for (String i :provices
             ) {
            proviceMap.put(i, number);
            number = number + 1;
        }
    }

    public void testToPrint() {
        Set <String> keySet = proviceMap.keySet();

        for (String key : keySet
             ) {
            System.out.print(key);
            Object i = proviceMap.get(key);
            System.out.println(i.toString());
        }

    }

    public String getProviceNumber(String provice) {
        Object numnber = this.proviceMap.get(provice);
        if (numnber == null) {
            return "-1";
        } else {
            String numberString = numnber.toString();
            if (numberString.length() == 1) {
                numberString = "0" + numberString;
            }
            return numberString;
        }
    }

    public static void main(String[] args) {
        GetProviceNumber getProviceNumber = new GetProviceNumber();
        getProviceNumber.testToPrint();
        System.out.println("------------------------");
        System.out.print(getProviceNumber.getProviceNumber("台湾省"));
    }
}

