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

    private static void initSprites(){
        try {
            Resources.sprites.put("tank1",
                    ImageIO.read(
                            Objects.requireNonNull(GameWorld .class.getClassLoader().getResource("tank/tank1.png"),
                                    "Could not find tank1.png")));

            Resources.sprites.put("tank2",
                    ImageIO.read(
                            Objects.requireNonNull(GameWorld .class.getClassLoader().getResource("tank/tank2.png"),
                                    "Could not find tank2.png")));

//            Resources.sprites.put("menu",
//                    ImageIO.read(Resources.class.getClassLoader().getResource("menu/title.png")));

        } catch (IOException e) {
            e.printStackTrace();
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
