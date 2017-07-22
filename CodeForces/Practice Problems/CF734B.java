import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF734B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        long total = 0;
        
        int k2 = Integer.parseInt(st.nextToken());
        int k3 = Integer.parseInt(st.nextToken());
        int k5 = Integer.parseInt(st.nextToken());
        int k6 = Integer.parseInt(st.nextToken());
        
        int num256 = Math.min(k2,Math.min(k5,k6));
        
        total += num256 * 256l;
        
        k2 -= num256;
        k5 -= num256;
        k6 -= num256;
        
        int num32 = Math.min(k2,k3);
        
        total += num32 * 32l;
        
        output = ""+total;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}