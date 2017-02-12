import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Fence {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("fence.dat"));
        int numLoops = sc.nextInt();
        for (int loop = 0; loop < numLoops; loop++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            out.println((int) Math.ceil(((double)num1 * num2 * 2) / 150));
        }
    }
}