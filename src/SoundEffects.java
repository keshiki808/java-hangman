import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundEffects extends Thread implements Runnable {

    private String soundPathString;

    public void setSoundPathString(String soundPathString) {
        this.soundPathString = soundPathString;
    }

    public void playSound(String path){
        SoundEffects sound = new SoundEffects();
        sound.setSoundPathString(path);
        Thread thread = new Thread(sound);
        thread.start();
    }

    public void run(){

        try{
            File soundPath = new File(soundPathString);
            if(soundPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                Thread.sleep(4000);
                clip.stop();
            }else{
                System.out.println("");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


}
