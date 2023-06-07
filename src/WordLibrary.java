import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// Third level class - Manages the comparison between player-created words and the english dictionary.
public class WordLibrary {

    private String[] words;
    private HashMap<String, Boolean> hashWord;


    WordLibrary() {
        loadWords("dictionary.txt");
        loadWordsHash("dictionary.txt");
    }


    private void loadWords(String fileName) {
        ArrayList<String> tempWords = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String tempWord = br.readLine();
            while(tempWord != null) {
                tempWords.add(tempWord);
                tempWord = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        words = tempWords.toArray(new String[0]);
    }

    public void loadWordsHash(String fileName) {
        hashWord = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String tempWord = br.readLine();
            while(tempWord != null) {
                hashWord.put(tempWord, true);
                tempWord = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayWords() {
        System.out.println(Arrays.toString(words));
    }

    public boolean checkWord(String word) {
        for (int i = 0; i < words.length; i++) {
            String wlWord = words[i];
            if (word.equals(wlWord)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWordHash(String word) {
       return hashWord.containsKey(word);
    }


}
