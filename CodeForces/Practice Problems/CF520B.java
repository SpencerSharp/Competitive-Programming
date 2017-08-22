import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF520B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        long numSteps = 0;
        
        
        while(n!=m)
        {
            if(n==1)
            {
                n*=2;
            }
            else if(n > m)
            {
                n--;
            }
            else if(numPowerSteps(n,m) + (eventualPowerResult(n,m)-m) <= numPowerSteps(n-1,m) + (eventualPowerResult(n-1,m)-m))
            {
                //out.println("NUM1:"+(numPowerSteps(n,m) + (eventualPowerResult(n,m)-m)));
                //out.println("NUM2:"+(numPowerSteps(n-1,m) + (eventualPowerResult(n-1,m)-m)));
                n*=2;
            }
            else
            {
                //out.println("NUM1:"+(numPowerSteps(n,m) + (eventualPowerResult(n,m)-m)));
                //out.println("NUM2:"+(numPowerSteps(n-1,m) + (eventualPowerResult(n-1,m)-m)));
                n--;
            }
            numSteps++;
            //out.println(n);
        }
        
        output = ""+numSteps;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static long eventualPowerResult(long n, long m)
    {
        long steps = 0;
        while(n<m)
        {
            n*=2;
            steps++;
        }
        return n;
    }
    
    public static long numPowerSteps(long n, long m)
    {
        long steps = 0;
        while(n<m)
        {
            n*=2;
            steps++;
        }
        return steps;
    }
}