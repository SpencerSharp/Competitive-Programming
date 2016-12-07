import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF1A
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
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        
        long ratioVert = n / a;
        if(n%a!=0)
            ratioVert++;
        long ratioHoriz = m / a;
        if(m%a!=0)
            ratioHoriz++;
        long numSquares = ratioHoriz * ratioVert;
        output = ""+numSquares;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
