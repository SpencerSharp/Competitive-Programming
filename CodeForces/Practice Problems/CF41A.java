import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF41A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String inp1 = f.readLine();
        String inp2 = f.readLine();
        output = reverse(inp1).equals(inp2)?"YES":"NO";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static String reverse(String s)
    {
        String ret = "";
        for(int i = s.length()-1; i>=0; i--)
        {
            ret += s.charAt(i);
        }
        return ret;
    }
}