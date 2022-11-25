package tankrotationexample.game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class PowerUp extends GameObject{
    float x,y;
    BufferedImage img;

    public PowerUp(float x, float y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
        this.hitbox = new Rectangle((int)x,(int)y,this.img.getWidth(), this.img.getHeight());
    }
}
