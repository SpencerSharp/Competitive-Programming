import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class PPrime {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("pprime.dat"));
        int numLoops = sc.nextInt();
        for (int loop = 0; loop < numLoops; loop++) {
            int num = sc.nextInt();
            if ((inRange(num)) && (isPrime(num)) && (isPal(num))) {
                out.println("yes");
            }
            else {
                out.println("no");
            }
        }
    }
    
    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPal(int num) {
        String s = num + "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean inRange(int num) {
        if (num > 9) {
            if (num < 1000000000) {
                return true;
            }
        }
        return false;
    }
}