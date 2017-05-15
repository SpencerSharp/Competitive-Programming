import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF474A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String key = "qwertyuiop" +
                    "asdfghjkl;" +
                    "zxcvbnm,./";
        String shift = f.readLine();
        String inp = f.readLine();
        boolean isRight = shift.equals("R");
        if(isRight)
        {
            for(int i = 0; i < inp.length(); i++)
            {
                output += key.charAt(key.indexOf(inp.charAt(i))-1);
            }
        }
        else
        {
            for(int i = 0; i < inp.length(); i++)
            {
                output += key.charAt(key.indexOf(inp.charAt(i))+1);
            }
        }
        
        
        //Code here

        
        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
