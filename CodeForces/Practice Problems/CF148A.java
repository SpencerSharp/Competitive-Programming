import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF148A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long k = Long.parseLong(f.readLine());
        long l = Long.parseLong(f.readLine());
        long m = Long.parseLong(f.readLine());
        long n = Long.parseLong(f.readLine());
        long d = Long.parseLong(f.readLine());
        long damaged = 0;
        for(long i = 1; i <= d; i++)
        {
            if(i%k==0||i%l==0||i%m==0||i%n==0)
                damaged++;
        }
        output = ""+damaged;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}