import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF577A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        long maxFactor = Long.parseLong(st.nextToken());
        long maxRow = maxFactor;
        long target = Long.parseLong(st.nextToken());
        if(maxFactor > Math.sqrt(target))
            maxFactor = (long)Math.sqrt(target);
        
        long total = 0;
        
        for(long factor = 1; factor <= maxFactor; factor++)
        {
            if(target%factor==0 && target/factor <= maxRow)
            {
                //out.println(factor);
                total += 2;
                if(factor==Math.sqrt(target))
                    total--;
            }
        }
        output = ""+total;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
