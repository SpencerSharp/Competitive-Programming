import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Vowel {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("vowel.dat"));
        int numLoops = sc.nextInt();
        for (int loop = 0; loop < numLoops; loop++) {
            String word1 = sc.next();
            String word2 = sc.next();
            int num1 = Integer.parseInt(binaryOfWord(word1),2);
            int num2 = Integer.parseInt(binaryOfWord(word2),2);
            out.println((num1&num2) + " " + (num1|num2) + " " + (num1^num2));
        }
    }
    
    public static String isVowel(char c)
    {
        if(c=='a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return "1";
        return "0";
    }
    
    public static String binaryOfWord(String w)
    {
        String ret = "";
        for(int i = 0; i < w.length(); i++)
            ret += isVowel(w.charAt(i));
        return ret;
    }
}