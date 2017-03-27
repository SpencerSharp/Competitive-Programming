import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF486A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long n = Long.parseLong(f.readLine());
        output = ""+(((n+1)/2)*(n%2==1?-1:1));
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static long calcFuncResult(long n)
    {
        long res = 0;
        for(long i = 1; i <= n; i++)
        {
            long temp = i;
            if(i%2==1)
                temp *= -1;
            res += temp;
        }
        return res;
    }
}