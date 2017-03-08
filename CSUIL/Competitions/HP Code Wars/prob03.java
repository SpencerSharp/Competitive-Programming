import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("prob03.txt"));
        double constant = .299792;
        while(file.hasNextLine()) {
            int time = file.nextInt();
            double distance = time * constant;
            System.out.println(distance);
        }
    }
}