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

    public static void main(String[] args) {
        image lpImage = new image();

    }

}
