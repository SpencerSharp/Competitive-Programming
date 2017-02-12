import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Factoring {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("factoring.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int loop = 0; loop < numLoops; loop++) {
            String s = sc.nextLine();
            String[] line = s.split(" ");
            int n1 = Integer.parseInt(line[0].substring(0, line[0].length() - 2));
            int n2 = Integer.parseInt(line[2].substring(0, line[2].length() - 1));
            int n3 = Integer.parseInt(line[4]);
            int fnum = n1 * n3;
            int[] fctrs = factors(fnum);
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < fctrs.length; i++) {
                if (fctrs[i] + fctrs[fctrs.length - 1 - i] == n2) {
                    sum1 = fctrs[i];
                    sum2 = fctrs[fctrs.length - 1 - i];
                }
            }
            int a = gcf(n1, sum1);
            int b = gcf(sum2, n3);
            int c = n1/a;
            int d = sum1/a;
            System.out.println("(" + a + "x + " + b + ")(" + c + "x + " + d + ")");
        }
    }
    
    public static int[] factors (int n) {
        ArrayList<Integer> factor = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                factor.add(i);
        }
        int[] ray = new int[factor.size()];
        int i = 0;
        for (int num : factor) {
            ray[i++] = num;
        }
        return ray;
    }
    
    public static int gcf(int n1, int n2) {
        int largest = 1;
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0)
                largest = i;
          
        }
        return largest;
    }
}