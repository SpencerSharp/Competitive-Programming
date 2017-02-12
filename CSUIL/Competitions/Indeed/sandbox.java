import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class sandbox {
    public static void main(String[] args) throws IOException {
        String fileName = "sandbox.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        for (int i = 0; i < numLoops; i++) {
            int l = sc.nextInt();
            int w = sc.nextInt();
            double d = sc.nextInt()/12.0;
            double dimensions = l * w * d;
            out.println((int) Math.ceil(dimensions/2.0));
        }
    }
    
}
