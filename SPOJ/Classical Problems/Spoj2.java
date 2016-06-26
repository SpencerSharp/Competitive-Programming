import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Spoj2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        long size = Long.parseLong(f.readLine());
        for(long j = 0; j < size; j++)
        {
            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            long n1 = Long.parseLong(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());
            boolean[] mark = new boolean[(int)n2+1];
            for (int p=2; p*p<=n2; p++)
            {
                //out.println(p);
                // If p is not changed, then it is a prime
                if (mark[p] == false)
                {
                    // Update all multiples of p
                    for (int i=p*2; i<=Math.sqrt(n2)+1; i+=p)
                    {
                        //out.println("loop");
                        mark[i] = true;
                    }
                    long numToMultiply = n1/p;
                    for (int i=(int)numToMultiply*p; i<n2; i+=p)
                        mark[i] = true;
                }
            }
            mark[1] = true;
            mark[2] = false;
            for(int p = (int)n1; p <= n2; p++)
            {
                if(mark[p]==false)
                    output += p + "\n";
            }
            output += "\n";
        }
        output = output.substring(0,output.length()-2);
        
        
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static boolean isPrimeNumber(long number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static HashSet<Long> genHashSet(long min, long max)
    {
        HashSet<Long> ret = new HashSet<Long>();
        for(long i = min; i <= max; i++)
        {
            ret.add(i);
        }
        return ret;
    }
}