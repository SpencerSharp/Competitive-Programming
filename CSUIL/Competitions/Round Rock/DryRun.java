import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class DryRun {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("dryrun.dat"));
        int numLoops = sc.nextInt();
        for (int loop = 0; loop < numLoops; loop++) {
            out.println("I like " + sc.next() + ".");
        }
    }
}