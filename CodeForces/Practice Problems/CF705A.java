import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF705A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        
        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        output = "I hate";
        for(int i = 1; i < n; i++)
        {
            if(i%2==1)
                output += " that I love";
            else
                output += " that I hate";
        }
        output += " it";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
