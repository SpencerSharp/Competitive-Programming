import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class FCTRL2
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int size = Integer.parseInt(f.readLine());
        for(int n = 0; n < size; n++)
        {
            long cur = Integer.parseInt(f.readLine());
            BigInteger fact = getFactorial(cur);
            writer.println(fact);
        }
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
    }
    
    public static BigInteger getFactorial(long n)
    {
        BigInteger cur = new BigInteger(""+n);
        if(n==1)
            return new BigInteger(""+1);
        else
            return cur.multiply(new BigInteger(""+getFactorial(n-1)));
    }
}