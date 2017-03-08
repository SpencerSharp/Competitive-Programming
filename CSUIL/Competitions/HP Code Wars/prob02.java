import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob02 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("prob02.txt"));
        int mass = file.nextInt();
        int volume = file.nextInt();
        int value = mass * volume;
        out.println(value);
    }
}
