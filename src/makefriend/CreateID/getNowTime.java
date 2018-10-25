package makefriend.CreateID;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getNowTime {

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    private String nowTime = null;

    public getNowTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        nowTime = dateFormat.format(now);
    }

    public String getDateTime() {
        return nowTime;
    }

    public String getDate() {
        String time = new String();
        time = nowTime.substring(0, 10);
        return time;
    }

    public String getTime() {
        String date = new String();
        date = nowTime.substring(11, nowTime.length());
        return date;
    }

    public String getUsedStringForID() {
        String yourID = "";
        for (int i = 0; i < nowTime.length(); i++)
            if (i==0||i==1||i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 9) {
                yourID = yourID + nowTime.charAt(i);
            }
        return yourID;
    }

    public static void main(String[] args) {
        System.out.print(new getNowTime().getUsedStringForID());
        System.out.println(new getNowTime().getDateTime());
        System.out.println(new getNowTime().getDate());
        System.out.println(new getNowTime().getTime());
    }
}
