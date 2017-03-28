import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF82A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        //out.println((int)Math.pow(10,9));
        int max = Integer.parseInt(f.readLine());
        output = getNum(max);
        
        //out.println(output);
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static String getNum(long n)
    {
        long total = 0;
        long next = 5;
        while(total+next < n)
        {
            total += next;
            next *=2;
        }
        long rem = n - total;
        if(rem <= next * 0.2)
            return "Sheldon";
        if(rem <= next*0.4)
            return "Leonard";
        if(rem <= next*0.6)
            return "Penny";
        if(rem <= next*0.8)
            return "Rajesh";
        if(rem <= next)
            return "Howard";
        return "";
    }
}