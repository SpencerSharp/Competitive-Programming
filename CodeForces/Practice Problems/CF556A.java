import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF556A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        f.readLine();
        String input = f.readLine();
        int total0 = 0;
        int total1 = 0;
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i)=='0')
                total0++;
            else
                total1++;
        }
        //out.println(input);
        output = ""+Math.abs(total0-total1);
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
