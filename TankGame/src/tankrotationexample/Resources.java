package tankrotationexample;
import tankrotationexample.game.GameWorld;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Resources {

    private static Map<String, BufferedImage> sprites = new HashMap<>();
    private static Map<String, Clip> sounds = new HashMap<>();
    private static Map<String, List<BufferedImage>> animations = new HashMap<>();

    private static BufferedImage loadSprite(String path) throws IOException{
        return ImageIO.read(Objects.
                requireNonNull(GameWorld
                .class
                .getClassLoader()
                .getResource(path)));
    }

    private static void initSprites(){
        try {
            Resources.sprites.put("tank1", loadSprite("tank/tank1.png"));
            Resources.sprites.put("tank2", loadSprite("tank/tank2.png"));
            Resources.sprites.put("bullet", loadSprite("bullet/Bullet.png"));
            Resources.sprites.put("rocket1", loadSprite("bullet/rocket1.png"));
            Resources.sprites.put("rocket2", loadSprite("bullet/rocket2.png"));
            Resources.sprites.put("floor", loadSprite("floor/bg.bmp"));
            Resources.sprites.put("unbreak", loadSprite("walls/unbreak.png"));
            Resources.sprites.put("break1", loadSprite("walls/break1.png"));
            Resources.sprites.put("break2", loadSprite("walls/break2.png"));
            Resources.sprites.put("speed", loadSprite("powerups/speed.png"));
            Resources.sprites.put("health", loadSprite("powerups/health.png"));
            Resources.sprites.put("shield", loadSprite("powerups/shield.png"));
//            Resources.sprites.put("menu", loadSprite("menu/title.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    private static void initSounds(){

    }
    private static void initAnimations(){

    }

    public static void loadResources(){
        initSprites();
        initSounds();
        initAnimations();
    }

    public static BufferedImage getSprites(String key){
        return Resources.sprites.get(key);
    }
}
