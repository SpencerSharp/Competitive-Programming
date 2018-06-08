import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
FROM UIL SET A PROGRAMMING PRACTICE
*/
public class Maria {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        while(sc.hasNext())
        {
            out.println(getDispOfVal(Integer.parseInt(sc.next())));
        }
    }
    
    public static String getDispOfVal(int n)
    {
        switch(n)
        {
            case 1:
                return    "---\n"
                        + "-*-\n"
                        + "---\n";
            case 2:
                return    "*--\n"
                        + "---\n"
                        + "--*\n";
            case 3:
                return    "*--\n"
                        + "-*-\n"
                        + "--*\n";
            case 4:
                return    "*-*\n"
                        + "---\n"
                        + "*-*\n";
            case 5:
                return    "*-*\n"
                        + "-*-\n"
                        + "*-*\n";    
            case 6:
                return    "*-*\n"
                        + "*-*\n"
                        + "*-*\n";    
        }
        return "";
    }
}