import static java.lang.System.*;
import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class DryRun {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("dryrun.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            System.out.println("I like " + sc.nextLine() + ".");
        }
    }
}
