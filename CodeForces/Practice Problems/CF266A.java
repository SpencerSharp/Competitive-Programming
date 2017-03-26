import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF266A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int lengthOfString = Integer.parseInt(f.readLine());
        String line = f.readLine();
        boolean canLoop = true;
        while(canLoop)
        {
            int removeVal = doesHaveNeighboring(line);
            if(removeVal >= 0)
            {
                line = removeCharFromString(line,removeVal);
            }
            else
            {
                canLoop = false;
            }
        }
        output = ""+(lengthOfString - line.length());
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int doesHaveNeighboring(String s)
    {
        char prev = '0';
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            if(prev==cur)
            {
                return i-1;
            }
            else
            {
                prev = cur;
            }
        }
        return -1;
    }
    
    public static String removeCharFromString(String s, int index)
    {
        if(index < s.length()-1)
            return s.substring(0,index) + s.substring(index+1);
        else
            return s.substring(0,index);
    }
}