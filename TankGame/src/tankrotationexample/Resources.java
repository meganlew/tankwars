package tankrotationexample;
import tankrotationexample.game.GameWorld;
import tankrotationexample.game.Sound;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Resources {

    private static Map<String, BufferedImage> sprites = new HashMap<>();
    private static Map<String, Sound> sounds = new HashMap<>();
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
        AudioInputStream audioStream;
        Clip c;
        Sound s;

        try {
            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/Music.mid")
            );
            c = AudioSystem.getClip();
            c.open((audioStream));
            s = new Sound(c);
            Resources.sounds.put("bg", s);

            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/pickup.wav")
            );
            c = AudioSystem.getClip();
            c.open((audioStream));
            s = new Sound(c);
            Resources.sounds.put("powerup", s);

            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/bullet.wav")
            );
            c = AudioSystem.getClip();
            c.open((audioStream));
            s = new Sound(c);
            Resources.sounds.put("shoot", s);

            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/Explosion_small.wav")
            );
            c = AudioSystem.getClip();
            c.open((audioStream));
            s = new Sound(c);
            Resources.sounds.put("bullethit", s);


        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    private static void initAnimations(){

    }

    public static void loadResources(){
        initSprites();
        initSounds();
        initAnimations();
    }

    public static BufferedImage getSprites(String key){
        if(!Resources.sprites.containsKey(key)){
            System.out.println(key + "resource not found");
            System.exit(-2);
        }
           return Resources.sprites.get(key);
    }

    public static Sound getSound(String key){
        if(!Resources.sounds.containsKey(key)){
            System.out.println(key + "sound not found");
            System.exit(-2);
        }
        return Resources.sounds.get(key);
    }
}
