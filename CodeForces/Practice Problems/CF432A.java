import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF432A
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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long numValids = 0;
        long validThreshold = 5 - k + 1;
        line = f.readLine();
        st = new StringTokenizer(line);
        while(st.hasMoreTokens())
        {
            long next = Integer.parseInt(st.nextToken());
            if(next<validThreshold)
                numValids++;
        }
        output =""+(numValids/3);
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
