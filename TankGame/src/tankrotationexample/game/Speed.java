package tankrotationexample.game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Speed extends GameObject {

    float x,y;
    BufferedImage img;

    public Speed(float x, float y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
        this.hitbox = new Rectangle((int)x,(int)y,this.img.getWidth(), this.img.getHeight());
    }


    public void drawImage(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(this.img,(int)x,(int)y,null);
        g2d.setColor(Color.YELLOW);
        g2d.drawRect((int)x,(int)y,this.img.getWidth(), this.img.getHeight());

    }
}
