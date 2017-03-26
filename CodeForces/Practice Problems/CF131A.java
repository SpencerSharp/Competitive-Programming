import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF131A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String word = f.readLine();
        //out.println('')
        if(isCapsLock(word))
        {
            for(int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                if(c >= 'a')
                    c-=32;
                else
                    c += 32;
                output += c;
            }
        }
        else
        {
            output = word;
        }
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }

    public static boolean isCapsLock(String s)
    {
        return s.substring(1).toUpperCase().equals(s.substring(1));
    }
}