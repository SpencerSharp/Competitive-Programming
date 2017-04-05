import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF339B
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
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        line = f.readLine();
        st = new StringTokenizer(line);
        long cur = 1;
        long dist = 0;
        while(st.hasMoreTokens())
        {
            long next = Long.parseLong(st.nextToken());
            if(next >= cur)
            {
                dist += next-cur;
            }
            else
            {
                dist += n-cur;
                dist += next;
            }
            cur = next;
        }
        output = ""+dist;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
