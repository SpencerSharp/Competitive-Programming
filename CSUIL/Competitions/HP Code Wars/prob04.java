import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob04 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("prob04.txt"));
        int size = file.nextInt();
        file.nextLine();
        for(int i = 0; i < size; i++) {
            double miles = file.nextDouble();
            int minutes = file.nextInt();
            double avgSpeed = miles / minutes;
            avgSpeed *= 60;
            out.println(avgSpeed);
        }
    }
}