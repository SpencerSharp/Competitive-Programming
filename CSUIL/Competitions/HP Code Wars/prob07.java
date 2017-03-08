import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("prob07.txt"));
        int numLoops = file.nextInt();
        for (int loop = 0; loop < numLoops; loop++) {
            String toPrint = "DIVERGES";
            double lastVal = file.nextDouble();
            double A = file.nextDouble();
            double B = file.nextDouble();
            double C = file.nextDouble();
            double M = file.nextDouble();
            double N = file.nextDouble();
            double accError = file.nextDouble();
            for (int i = 0; i < 100; i++) {
                double nextVal = C + (A*lastVal + M)/(B*lastVal + N);
                double lastError = Math.abs(nextVal-lastVal);
                if (lastError < accError) {
                    toPrint = "" + String.format("%.6f", nextVal);
                    break;
                }
                lastVal = nextVal;
            }
            System.out.println(toPrint);
        }
    }
}

