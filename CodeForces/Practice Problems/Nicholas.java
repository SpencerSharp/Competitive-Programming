import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Nicholas
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int nums = Integer.parseInt(f.readLine());
        long[] ray = new long[nums];
        String line = f.readLine();
        StringTokenizer t = new StringTokenizer(line);
        int c = 0;
        while(t.hasMoreTokens())
        {
            ray[c] = Long.parseLong(t.nextToken());
            c++;
        }
        long maxDist = 0;
        for(int n1 = 0; n1 < nums; n1++)
            for(int n2 = 0; n2 < nums; n2++)
            {
                long dist = getMinMaxDist(getSwap(ray,n1,n2));
                //out.println(n1 + " " + n2 + " " + dist);
                if(dist>maxDist)
                    maxDist = dist;
            }
        
        
        output += maxDist;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static long[] copy(long[] ray)
    {
        long[] ret = new long[ray.length];
        int c = 0;
        for(long n : ray)
        {
            ret[c] = n;
            c++;
        }
        return ret;
    }
    
    public static long[] getSwap(long[] ray, int s1, int s2)
    {
        long[] op = copy(ray);
        op[s1] = ray[s2];
        op[s2] = ray[s1];
        return op;
    }
    public static long getMinMaxDist(long[] ray)
    {
        long indexMin = 0;
        long indexMax = 0;
        long min = ray[0];
        long max = ray[0];
        for(int i = 0; i < ray.length; i++)
        {
            long n = ray[i];
            if(n<min)
            {
                indexMin = i;
                min = n;
            }
            if(n>max)
            {
                indexMax = i;
                max = ray[i];
            }
        }
        return Math.abs(Math.abs(indexMin)-Math.abs(indexMax));   
    }
}
