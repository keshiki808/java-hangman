import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class WordBank {
    private ArrayList<String> wordList;

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public WordBank() throws IOException {
        wordList = new ArrayList<String>();
        Scanner wordInput = new Scanner(new File("wordlist.txt"));
        while (wordInput.hasNextLine()) {
            wordList.add(wordInput.nextLine());
        }
        wordInput.close();
        Collections.shuffle(wordList);
    }
}
