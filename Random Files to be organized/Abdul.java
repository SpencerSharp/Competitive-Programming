import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
FROM UIL SET A PROGRAMMING PRACTICE
*/
public class Abdul {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        while(sc.hasNext())
        {
            int num = Integer.parseInt(sc.next());
            int sum = 0;
            for(int i = 1; i < num*2; i+=2)
                sum += i;
            out.println(sum);
        }
    }
}