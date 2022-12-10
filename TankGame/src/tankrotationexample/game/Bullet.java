package tankrotationexample.game;

import tankrotationexample.GameConstants;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject{
    private int tankId;
    float R = 6;
    float angle = 0;
    float vx=0;
    float vy=0;


    public Bullet(float x, float y, float angle, BufferedImage img){
        super(x,y,img);
//        this.tankId = tankID;
        this.angle = angle;

    }

    void update(){
        x += Math.round(R * Math.cos(Math.toRadians(angle)));
        y += Math.round(R * Math.sin(Math.toRadians(angle)));
        checkBorder();
    }

    public void drawImage(Graphics g) {
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

    private void checkBorder() {
        // check border remove bullets from the screen,  when set to this.hasCollided = false;
        // instead of setting these values return true or false
        // false haven't hit a wall
        // true hit a wall
        if (x < 30) {
//            x = 30;
            this.hasCollided = false;
        }
        if (x >= GameConstants.WORLD_WIDTH - 88) {
//            x = GameConstants.WORLD_WIDTH - 88;
            this.hasCollided = false;
        }
        if (y < 40) {
//            y = 40;
            this.hasCollided = false;
        }
        if (y >= GameConstants.WORLD_HEIGHT - 80) {
//            y = GameConstants.WORLD_HEIGHT - 80;
            this.hasCollided = false;
        }
    }

    public int getTankId() {
        return tankId;
    }
}
