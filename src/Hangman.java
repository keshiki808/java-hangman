import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import  java.util.Scanner;
public class Hangman {

    public static void main(String[] args) throws IOException {
        int guessNumber = 0;
        String chosenWord;
        int incorrectGuesses = 0;
        int round = 0;
        String playerGuess;
        System.out.println("Welcome to Hangman");
        WordBank gameWordList = new WordBank();
        System.out.println(gameWordList.getWordList());
        String path = "music/kaiengel_headway.wav";
        Music musicObj = new Music();
        musicObj.playMusic(path);

        if (round == gameWordList.getWordList().size()){
            System.out.println("The entire word bank has been exhausted, starting over.");
            round = 0;
            gameWordList = new WordBank();
        }
        chosenWord = wordGetter(gameWordList,round);

        Scanner keyboard = new Scanner(System.in);


        if (chosenWord.indexOf(playerGuess) != -1){


        }






    }
        public static String wordGetter(WordBank wordList,int roundNum){
            return wordList.getWordList().get(roundNum);

        }

        public static char guessValidator(Scanner scannerObj){
            String playerGuess;
            while(playerGuess.length != 1 && !Character.isLetter(playerGuess.charAt(0))) {
                System.out.println("Please guess a letter");
                playerGuess = scannerObj.nextLine();
            }
            return playerGuess
        }

        public static letterFinder(String word, char guess){

        }


}




