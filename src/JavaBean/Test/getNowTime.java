package JavaBean.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getNowTime {

    private String nowTime = null;

    public getNowTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        nowTime = dateFormat.format( now );
    }

    public String getUsedStringForID() {
        String yourID = "";
        for (int i = 0; i<nowTime.length(); i++)
            if (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 9) {
                yourID = yourID + nowTime.charAt(i);
            }
        return yourID;
    }

    public static void main(String[] args) {
        System.out.print(new getNowTime().getUsedStringForID());
    }
}
