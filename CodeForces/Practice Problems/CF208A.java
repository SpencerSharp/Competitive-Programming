import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF208A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        String[] ray = line.split("(WUB)+");
        for(String s : ray)
        {
            if(containsNonSpaces(s))
                output += s + " ";
        }
        output = output.substring(0,output.length()-1);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean containsNonSpaces(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)!=' ')
            {
                return true;
            }
        }
        return false;
    }
}