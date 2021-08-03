import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
public class Music extends Thread{
     public void run(){

        try{
            File songPath = new File("music/kaiengel_headway.wav");
            if(songPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(songPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                while(clip.isOpen());
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
