import java.io.IOException;
import java.util.ArrayList;
import  java.util.Scanner;
public class Hangman {

    public static void main(String[] args) throws IOException {
        String chosenWord;
        int incorrectGuesses;
        int playAgainResponse = 1;
        char playerGuess;
        int difficulty_index;
        String difficulty;
        ArrayList<Character> guessedLetters;
        System.out.println("Welcome to Hangman");
        Music musicObj = new Music();
        musicObj.start();
        SoundEffects soundsObj = new SoundEffects();
        WordBank gameWordList = new WordBank();
        Scanner keyboard = new Scanner(System.in);


//      easy/medium/hard round counters to ensure the lists are random and don't repeat until exhausted
        int[] roundsArray = new int[3];

//      Sets up the game round
        while (playAgainResponse == 1) {
            incorrectGuesses = 0;
            guessedLetters = new ArrayList<Character>();
            StringBuilder spaces = new StringBuilder();

//          Allows the user to select a game difficulty
            difficulty = difficultySelector(keyboard);

//          Assigns an index based on the game difficulty selection
            difficulty_index = difficultyRoundIndex(difficulty);

            System.out.println(gameWordList.getWordList(difficulty));
//          Checks if the list of words is exhausted and if so shuffles and randomizes the list before traversing again
            exhaustedListChecker(gameWordList, roundsArray, difficulty, difficulty_index);

            chosenWord = wordGetter(gameWordList, roundsArray[difficulty_index], difficulty).toLowerCase();

//          Tracks already selected words so no repeats until every word for selected difficulty was used once
            roundsArray[difficulty_index]+=1;

            spacesBuilder(chosenWord, spaces);

            Drawer.hangmanBoardDrawer(incorrectGuesses);

            System.out.println(spaces);

//          Main game loop
            while (incorrectGuesses != 6 && spaces.indexOf("_") != -1) {

//              Ensures the player guessed a single letter that wasn't already guessed'
                playerGuess = guessValidator(keyboard, guessedLetters);

//              Logic to identify a correct or incorrect guess
                if (chosenWord.indexOf(playerGuess) != -1) {
                    letterFinder(chosenWord, playerGuess, spaces);
                    soundsObj.playSound("sounds/Mario Coin.wav");

                } else {
                    incorrectGuesses += 1;
                    soundsObj.playSound("sounds/wrong.wav");
                }

                Drawer.hangmanBoardDrawer(incorrectGuesses);
                System.out.println(spaces);
                System.out.print("Guess letters: ");
                for (char letter : guessedLetters){
                    System.out.print(letter + ", ");
                }
                System.out.println();
            }

            resultsDisplay(chosenWord, incorrectGuesses, soundsObj);

            playAgainResponse = playAgain(keyboard);
        }
        System.out.println("Quitting game...");
        System.exit(0);
    }

//      Gets the word from the word bank as a string
        public static String wordGetter(WordBank wordList,int roundNum, String difficulty){
            return wordList.getWordList(difficulty).get(roundNum);
        }

        public static char guessValidator(Scanner scannerObj, ArrayList<Character> guessedLetters){
            String playerGuess;
            while(true) {
                System.out.println("Please guess a single letter ");
                playerGuess = (scannerObj.next()).toLowerCase();
                if (guessedLetters.contains(playerGuess.charAt(0)) && playerGuess.length()==1) {
                    System.out.println("You've already guessed that, try again");}
                else if(playerGuess.length()==1){
                    if(Character.isLetter(playerGuess.charAt(0))){
                        guessedLetters.add(playerGuess.charAt(0));
                        return playerGuess.charAt(0);
                    }
                }
            }
        }
//      Changes spaces on gameboard in response to correct guesses
        public static void letterFinder(String word, char guess, StringBuilder spaces){
        for(int i = 0; i< word.length(); i++){
            if (word.charAt(i) == guess){
                    spaces.setCharAt(i*2, guess);
                }
            }
        }

//      Assigns spaces based on length of word
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

        public static String difficultySelector(Scanner scanObj){
            int difficultyNum = 0;
            while (difficultyNum !=1 && difficultyNum !=2 && difficultyNum !=3){
                System.out.println("Please choose a difficulty:Enter 1 for easy, 2 for medium, 3 for hard");
                difficultyNum = scanObj.nextInt();
            }
            if (difficultyNum == 1){
                return "easy";
            } else if (difficultyNum == 2){
                return "medium";
            } else if (difficultyNum == 3){
                return "hard";
            }
            return "";
        }

        public static void exhaustedListChecker(WordBank wordList, int[] wordListRound, String difficulty, int roundIndex){
            if (wordListRound[roundIndex] == wordList.getWordList(difficulty).size()){
                System.out.println("The entire word bank has been exhausted, reshuffling and starting over.");
                wordListRound[roundIndex] = 0;
                wordList.shuffler(wordList.getWordList(difficulty));
            }
        }

        public static int playAgain(Scanner scanObj){
            System.out.println("Press 1 to play again or any other number to quit >>");
            return scanObj.nextInt();
        }

        public static int difficultyRoundIndex(String difficulty){
            int index = switch (difficulty) {
                case "easy" -> 0;
                case "medium" -> 1;
                case "hard" -> 2;
                default -> 0;
            };
            return index;
        }

        }







