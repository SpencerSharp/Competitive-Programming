import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob01 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("prob01.txt"));
        String name = file.next();
        System.out.println("Well met, " + name + "!");
    }
}
