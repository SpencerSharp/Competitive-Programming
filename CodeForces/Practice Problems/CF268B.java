import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF268B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long inp = Integer.parseInt(f.readLine());
        output = ""+getRes(inp);
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static long getRes(long inp)
    {
        long total = 0;
        for(long i = inp; i > 1; i--)
        {
            long temp = (inp-i+1)*(i-1)+1;
            //out.println(temp);
            total += temp;
        }
        return total+1;
    }
}