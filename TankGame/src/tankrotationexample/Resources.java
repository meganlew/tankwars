package tankrotationexample;
import tankrotationexample.game.GameWorld;
import tankrotationexample.game.Sound;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

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

    private static Sound loadSound(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream as = AudioSystem.getAudioInputStream(
                Objects.requireNonNull(Resources.class.getClassLoader().getResource(path)));
        Clip clip = null;
        clip = AudioSystem.getClip();
        clip.open(as);
        Sound s = new Sound(clip);
        s.setVolume(2f);
        return s;
    }

    private static void initSounds(){
        try {
            Resources.sounds.put("bg", loadSound("sounds/Music.mid"));
            Resources.sounds.put("powerup", loadSound("sounds/pickup.wav"));
            Resources.sounds.put("shoot", loadSound("sounds/bullet.wav"));
        } catch (UnsupportedAudioFileException | IOException |LineUnavailableException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
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


    private static void initAnimations(){
        try{
            String base = "animations/bullet/shell-explosion-%04d.png";
            List<BufferedImage> temp = new ArrayList<>();
            for (int i = 0; i < 5; i++){
                String fName = String.format(base,i);
                temp.add(loadSprite(fName));
            }
            Resources.animations.put("shoot", temp);
            base = "animations/explosion/explosion-%04d.png";
            temp = new ArrayList<>();
            for (int i = 0; i < 5; i++){
                String fName = String.format(base,i);
                temp.add(loadSprite(fName));
            }
            Resources.animations.put("collide", temp);
        }catch(IOException e){
            e.printStackTrace();
            System.out.println(e);
            System.exit(-3);
        }
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


    public static List<BufferedImage> getAnimation(String key) {
        if(!Resources.animations.containsKey(key)){
            System.out.println(key + "sound not found");
            System.exit(-2);
        }
        return Resources.animations.get(key);
    }
}
