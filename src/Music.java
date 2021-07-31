import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
public class Music {
    void playMusic(String songLocation){

        try{
            File songPath = new File(songLocation);

            if(songPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(songPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
//                clip.loop(Clip.LOOP_CONTINUOUSLY);
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
