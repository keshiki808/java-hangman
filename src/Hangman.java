import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import  java.util.Scanner;
public class Hangman {

    public static void main(String[] args) throws IOException {
        int guessNumber = 0;
        String chosenWord;
        int incorrectGuesses = 0;
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        int round = 0;
        char playerGuess;
        StringBuilder spaces = new StringBuilder();
        System.out.println("Welcome to Hangman");
        WordBank gameWordList = new WordBank();
        System.out.println(gameWordList.getWordList());
//        String path = "music/kaiengel_headway.wav";
        Music musicObj = new Music();
        SoundEffects soundsObj = new SoundEffects();
        musicObj.start();

        soundsObj.playSound("sounds/Mario Coin.wav");
        soundsObj.playSound("sounds/sadtrombone.wav");


        if (round == gameWordList.getWordList().size()){
            System.out.println("The entire word bank has been exhausted, starting over.");
            round = 0;
            gameWordList = new WordBank();
        }

        Scanner keyboard = new Scanner(System.in);

        chosenWord = wordGetter(gameWordList,round).toLowerCase();

        spacesBuilder(chosenWord,spaces);

        Drawer.hangmanBoardDrawer(incorrectGuesses);

        System.out.println(spaces);

        while(incorrectGuesses!=6 && spaces.indexOf("_") != -1) {

            playerGuess = guessValidator(keyboard);
            System.out.println(playerGuess);


            if (chosenWord.indexOf(playerGuess) != -1) {
                letterFinder(chosenWord, playerGuess, spaces);
                soundsObj.playSound("sounds/Mario Coin.wav");

            } else {
                incorrectGuesses += 1;
            }
            guessNumber += 1;

            guessedLetters.add(playerGuess);

            Drawer.hangmanBoardDrawer(incorrectGuesses);
            System.out.println(spaces);
        }
        resultsDisplay(chosenWord, incorrectGuesses, soundsObj);


    }
        public static String wordGetter(WordBank wordList,int roundNum){
            return wordList.getWordList().get(roundNum);
        }

        public static char guessValidator(Scanner scannerObj){
            String playerGuess = "";
            while(true) {
                System.out.println("Please guess a letter");
                playerGuess = scannerObj.nextLine();
                if(playerGuess.length()==1){
                    if(Character.isLetter(playerGuess.charAt(0))){
                        return Character.toLowerCase(playerGuess.charAt(0));
                    }
                }
            }
        }

        public static void letterFinder(String word, char guess, StringBuilder spaces){
        for(int i = 0; i< word.length(); i++){
            if (word.charAt(i) == guess){
                    spaces.setCharAt(i*2, guess);
                }
            }
        }

        public static void spacesBuilder(String word, StringBuilder spaces){
        for(int i = 0; i< word.length(); i++){
            spaces.append("_ ");
        }
        }

        public static void resultsDisplay(String word, int incorrectGuessNum, SoundEffects sound){
        if(incorrectGuessNum !=6){
            System.out.println("Congrats, you guessed the word! It's " + word);
            sound.playSound("sounds/yeah.wav");
        } else{
            System.out.println("Sorry, you didn't guess the word... it was " + word);
            sound.playSound("sounds/sadtrombone.wav");
        }
        }


}




