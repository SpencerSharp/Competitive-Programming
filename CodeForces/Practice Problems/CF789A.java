import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF789A
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
        line = f.readLine();
        st = new StringTokenizer(line);
        long total = 0;
        for(long i = 0; i < n; i++)
        {
            long numPebs = Long.parseLong(st.nextToken());
            total += (numPebs/k)+1;
            if(numPebs%k==0)
                total--;
        }
        if(total%2==1)
            total++;
        total/=2;
        output = ""+total;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
