import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class WordBank {
    private ArrayList<String> easyWordList;
    private ArrayList<String> mediumWordList;
    private ArrayList<String> hardWordList;

    public ArrayList<String> getWordList(String difficulty) {
        if(difficulty.equals("easy")){
        return easyWordList;}
        else if(difficulty.equals("medium")){
            return mediumWordList;
        }else if(difficulty.equals("hard")){
            return hardWordList;
        }
        return easyWordList;
    }

    public void shuffler(ArrayList<String> wordList){
        Collections.shuffle(wordList);
    }

    public ArrayList wordBankReader(String path) throws IOException{
        ArrayList<String> wordList = new ArrayList<String>();
        Scanner wordInput = new Scanner(new File(path));
        while (wordInput.hasNextLine()) {
            wordList.add(wordInput.nextLine());
        }
        wordInput.close();
        Collections.shuffle(wordList);
        return wordList;
    }

    public WordBank() throws IOException {
        easyWordList = wordBankReader("easywordlist.txt");
        mediumWordList = wordBankReader("mediumwordlist.txt");
        hardWordList = wordBankReader("hardwordlist.txt");
    }
}
