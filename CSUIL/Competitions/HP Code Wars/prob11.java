import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob11 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("prob11-1-in.txt"));
        int rows = file.nextInt();
        int columns = file.nextInt();
        int noise = file.nextInt();
        int[] spaces = new int[file.nextInt() - 1];
        spaces[0] = file.nextInt();
        for (int i = 1; i < spaces.length; i++) {
            spaces[i] = spaces[i-1] + 1 + file.nextInt();
        }
        file.nextInt();
        int[] letterCounts = new int[26];
        char[] letters = new char[rows*columns];
        for (int i = 0; i < letters.length; i++) {
            char letter = file.next().charAt(0);
            letters[i] = letter;
            letterCounts[letter-'A']++;
        }
        out.println(Arrays.toString(letterCounts));
        ArrayList<Character> toRemove = new ArrayList<Character>();
        for (int i = 0; i < letterCounts.length; i++) {
            if (letterCounts[i] >= noise)
                toRemove.add((char)(i+65));
        }
        out.println(toRemove);
        ArrayList<Character> finalLetters = new ArrayList<Character>();
        for (int i = 0; i < letters.length; i++) {
            if (!toRemove.contains(letters[i]))
                finalLetters.add(letters[i]);
        }
        String finalPrint = "";
        for (int i = 0; i < spaces.length; i++) {
            finalLetters.add(spaces[i], ' ');
        }
        for (char c : finalLetters) {
            finalPrint += c;
        }
        out.println(finalPrint);
        
    }
}
