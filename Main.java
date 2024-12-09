import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");

        int twoLetterWords = twoLetterWords();
        System.out.println(twoLetterWords);

        int longestWords = longestWords();
        System.out.println(longestWords);

        int palindromes = palindromes();
        System.out.println(palindromes);

        s.close();
    }

    public static int twoLetterWords() throws FileNotFoundException {
        s = new Scanner(f);
        int total = 0;
        while (s.hasNext()) {
            String word = s.nextLine();
            if (word.length() == 2) total ++;
        }
        return total;
    }

    public static int longestWords() throws FileNotFoundException {
        s = new Scanner(f);
        int longest = 0;
        while (s.hasNext()) {
            String word = s.nextLine();
            if (word.length() > longest) longest = word.length();
        }

        s = new Scanner(f);
        ArrayList<String> listOfLongestWords = new ArrayList<String>();
        int total = 0;
        while (s.hasNext()) {
            boolean sameWord = false;
            String word = s.nextLine();
            if (word.length() == longest) {
                for (String longestWord: listOfLongestWords) {
                    if (word.equals(longestWord)) sameWord = true;
                }
                if (!sameWord) {
                    total ++;
                    listOfLongestWords.add(word);
                }
            }
        } 
        return total;
    }

    public static int palindromes() throws FileNotFoundException {
        s = new Scanner(f);
        int total = 0;
        while (s.hasNext()) {
            String word = s.nextLine();
            int repetitions = word.length() / 2;
            int i = 0;
            for (int r = 1; r <= repetitions; r++) {
                if (word.substring(i, i+1).equals(word.substring((word.length()-(i+1)), word.length()-i))) {
                    if (r == repetitions) total++;
                    else i++;
                }
                else break;
            }

        }
        return total;
    }
}