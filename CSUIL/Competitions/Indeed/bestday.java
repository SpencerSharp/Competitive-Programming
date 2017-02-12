import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class bestday {
    public static void main(String[] args) throws IOException {
        String fileName = "bestday.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        String[] names = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        for (int i = 0; i < numLoops; i++) {
            int [] days = new int[7];
            for (int t = 0; t < 7; t++) {
                days[t] = sc.nextInt();
            }
            
            int max = days[0];
            int maxSpot = 0;
            for (int n = 0; n < days.length; n++) {
                if (days[n] > max) {
                    maxSpot = n;
                    max = days[n];
                }
            }
            out.println(names[maxSpot]);
        }
    }
    
}
