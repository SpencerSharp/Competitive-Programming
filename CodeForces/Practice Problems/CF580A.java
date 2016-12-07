import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF580A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line;
        StringTokenizer st;
        line = f.readLine();
        st = new StringTokenizer(line);
        long numDays = Integer.parseInt(st.nextToken());
        line = f.readLine();
        st = new StringTokenizer(line);
        long prev = Long.parseLong(st.nextToken());
        long cur = prev;
        long max = 1;
        long streak = 1;
        for(long i = 0; i < numDays-1; i++)
        {
            
            cur = Long.parseLong(st.nextToken());
            //out.println(prev + " " + cur);
            if(cur>=prev)
                streak++;
            else
            {
                if(streak>max)
                    max = streak;
                streak = 1;
            }
            prev = cur;
        }
        if(streak>max)
            max = streak;
        output = ""+max;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
