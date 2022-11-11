package tankrotationexample.game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Bullet {
    float R = 6;
    float x,y;
    float angle = 0;
    float vx=0;
    float vy=0;
    BufferedImage img;

    public Bullet(float x, float y, float angle, BufferedImage img){
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.img = img;
    }

    void update(){
        x += Math.round(R * Math.cos(Math.toRadians(angle)));
        y += Math.round(R * Math.sin(Math.toRadians(angle)));
    }

    void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        rotation.scale(5, 5);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, rotation, null);
        g2d.setColor(Color.GREEN);
        //g2d.rotate(Math.toRadians(angle), bounds.x + bounds.width/2, bounds.y + bounds.height/2);
        // change size of bullet
        g2d.drawRect((int)x,(int)y,this.img.getWidth()*5, this.img.getHeight()*5);

    }
}
