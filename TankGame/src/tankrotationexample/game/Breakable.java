package tankrotationexample.game;

import java.awt.image.BufferedImage;

public class Breakable extends Wall{

    int state = 2;

    public Breakable(float x, float y, BufferedImage img){
        super(x,y,img);
    }
}

