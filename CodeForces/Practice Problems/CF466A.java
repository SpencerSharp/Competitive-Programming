import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF466A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        double effectiveBundleCost = (double)b/m;
        int totalCost = 0;
        if(effectiveBundleCost < a)
        {
            totalCost += (n/m)*b;
            n %= m;
        }
        else
        {
            totalCost = n * a;
            n = 0;
        }
        if(n > 0)
        {
            totalCost += n * a < b?n*a:b;
        }
        
        output = ""+totalCost;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
