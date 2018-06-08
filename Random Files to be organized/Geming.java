import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
FROM UIL SET A PROGRAMMING PRACTICE
*/
public class Geming {
    public static void main(String[] args) throws FileNotFoundException
    {
        Math m = null;
        out.println(m.sqrt(10.0));
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        while(sc.hasNext())
        {
            int num = Integer.parseInt(sc.next());
            out.println(num + " " + ~num);
        }
    }
}