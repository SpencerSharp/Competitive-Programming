import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF96A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int curLen0 = 0;
        int maxLen0 = 0;
        int curLen1 = 0;
        int maxLen1 = 0;
        String line = f.readLine();
        for(int i = 0; i < line.length(); i++)
        {
            char c = line.charAt(i);
            if(c=='0')
            {
                if(curLen1 > maxLen1)
                    maxLen1 = curLen1;
                curLen1 = 0;
                curLen0++;
            }
            else
            {
                if(curLen0 > maxLen0)
                    maxLen0 = curLen0;
                curLen0 = 0;
                curLen1++;
            }
            //out.println(curLen0 + " " + curLen1);
        }
        if(curLen1 > maxLen1)
            maxLen1 = curLen1;
        if(curLen0 > maxLen0)
            maxLen0 = curLen0;
        output = maxLen0>=7||maxLen1>=7?"YES":"NO";
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
