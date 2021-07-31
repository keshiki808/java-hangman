import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
            }else{
                System.out.println("");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


}
