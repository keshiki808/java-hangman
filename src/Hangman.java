import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import  java.util.Scanner;
public class Hangman {
    private int guessNumber = 0;
    private String chosenWord;
    private int incorrectGuesses = 0;
    private int round = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Hangman");
        WordBank gameWordList = new WordBank();
        System.out.println(gameWordList.getWordList());
        String path = "music/kaiengel_headway.wav";
        Music musicObj = new Music();
        musicObj.playMusic(path);
        if (round == listOfWords.getWordList().size()) {
            System.out.println("The entire word bank has been exhausted, starting over.");


        }

        public String getWord (WordBank listOfWords,int counter){

        }

    }
}




