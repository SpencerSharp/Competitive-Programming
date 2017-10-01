import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numWays = Integer.parseInt(f.readLine());
        
        if(numWays==1)
        {
            writer.println("1 1");
            writer.println("1");
        }
        else
        {
            int total = 2*numWays - 2;

            writer.println(total + " 2");
            writer.println("1 2");
        }
        
        //output = ""+total;
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}