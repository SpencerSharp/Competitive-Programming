import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF61A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String l1 = f.readLine();
        String l2 = f.readLine();
        for(int i = 0; i < l1.length(); i++)
        {
            output += l1.charAt(i)==l2.charAt(i)?"0":"1";
        }
        
        //Code here
        //out.println(output);
        
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
