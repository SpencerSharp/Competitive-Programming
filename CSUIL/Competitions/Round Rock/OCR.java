import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class OCR {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("ocr.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        
        
        for (int loop = 0; loop < numLoops; loop++) {
            String s1 = "";
            String s2 = "";
        int errors = 0;
            for (int i = 0; i < 8; i++) {
                s1 += sc.nextLine();
            }
            for (int j = 0; j < 8; j++) {
                s2 += sc.nextLine();
            }
            for (int l = 0; l < s1.length(); l++) {
                if (s1.charAt(l) != s2.charAt(l)) {
                    errors++;
                }
            }
            if (errors < 3) {
                out.println("yes");
            } else
                out.println("no");
        }
    }
}