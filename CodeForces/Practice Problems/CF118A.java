import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF118A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String input = f.readLine();
        input = input.toLowerCase();
        input = input.replaceAll("[aeiouy]", "");
        for(int i = 0; i < input.length(); i++)
        {
            output += "." + input.charAt(i);
        }
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
