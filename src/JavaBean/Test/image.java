package JavaBean.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class image {
    public image() {
        int width = 78;
        int heigth = 20;
        BufferedImage bufferedImage = new BufferedImage(68, 20, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        Random random = new Random();

        graphics.setColor(new Color(random.nextInt(100), 205, random.nextInt(100)));
        graphics.fillRect(0,0,width,heigth);

        StringBuffer stringBuffer = new StringBuffer("");
        for (int i=0;i<4;i++) {
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("华文隶书", Font.BOLD | Font.ITALIC, 22));
            int n = random.nextInt(10);

            stringBuffer.append(n);
            graphics.drawString("" + n, i * 15 + 5, 18);
        }
    }

    /*public static void main(String[] args) {
        image lpImage = new image();

    }*/

    public static void main(String[] args) {
        String string = "北京市，天津市，上海市，重庆市，河北省，山西省，辽宁省，吉林省，黑龙江省，" +
                "江苏省，浙江省，安徽省，福建省，江西省，山东省，河南省，湖北省，湖南省，广东省，海南省，四川省，贵州省，云南省，陕西省，甘肃省，青海省，台湾省，内蒙古自治区，广西壮族自治区，西藏自治区，宁夏回族自治区，新疆维吾尔自治区，香港特别行政区，澳门特别行政区";

        int l = string.length();
        char[] chars = string.toCharArray();

        for (int i=0;i<chars.length;i++) {
            if (chars[i] == '，') {
                System.out.print("\",");
                System.out.print("\n");
                System.out.print("\"");
            } else {
                System.out.print(chars[i]);
            }
        }


    }

}
