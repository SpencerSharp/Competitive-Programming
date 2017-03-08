import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob05 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("prob05.txt"));
        int size = file.nextInt();
        file.nextLine();
        double[] times = new double[size];
        String[] names = new String[size];
        for(int i = 0; i < size; i++) {
            String name = file.next();
            double distance = file.nextDouble();
            double speed = file.nextDouble();
            double time = distance / speed;
            times[i] = time;
            names[i] = name;
        }
        double max = Integer.MAX_VALUE;
        double current = 0;
        String name = "";
        for(int i =0; i < size; i++) {
            if(times[i] < max) {
                current = times[i];
                max = current;
                name = names[i];
            }
        }
        out.println(name + " " + current);
    }
}
