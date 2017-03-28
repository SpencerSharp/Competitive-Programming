import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF318A
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
        long k = Long.parseLong(st.nextToken());
        
        if(n%2==0)
        {
            if(k <= n/2)
            {
                output = ""+((k-1)*2+1);
            }
            else
            {
                output = ""+((k-(n/2))*2);
            }
        }
        else
        {
            if(k <= ((n/2)+1))
            {
                output = ""+((k-1)*2+1);
            }
            else
            {
                output = ""+((k-((n/2)+1))*2);
            }
        }
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
