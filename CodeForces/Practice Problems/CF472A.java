import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF472A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int inp = Integer.parseInt(f.readLine());
        int maxI = inp/2;
        for(int i = 4; i <= maxI; i++)
        {
            if(!isPrime(i) && !isPrime(inp-i))
            {
                output = i + " " + (inp-i);
                break;
            }
        }
        
        //out.println(output);
        //Code here
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean isPrime(int n)
    {
        for(int i = 2; i <= Math.sqrt(n); i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
}