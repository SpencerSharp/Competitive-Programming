import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF459B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long min = Long.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        int numFlowers = Integer.parseInt(f.readLine());
        
        HashMap<Long,Long> flowers = new HashMap<Long,Long>();
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        for(int i = 0; i < numFlowers; i++)
        {
            long num = Long.parseLong(st.nextToken());
            if(num > max)
                max = num;
            if(num < min)
                min = num;
            if(flowers.get(num)==null)
            {
                flowers.put(num, 1l);
            }
            else
            {
                flowers.put(num,flowers.get(num)+1);
            }
            //out.println(flowers);
        }
        
        //out.println(flowers);
        
        long totalWays = flowers.get(max)*flowers.get(min);
        
        if(min==max)
        {
            totalWays = flowers.get(min);
            if(totalWays==1)
            {
                totalWays = 0;
            }
            else if(totalWays==2)
            {
                totalWays = 1;
            }
            else if(totalWays==3)
            {
                totalWays = 3;
            }
            else if(totalWays%2==0)
            {
                totalWays = (totalWays)*((totalWays/2)-1)+(totalWays/2);
            }
            else
            {
                totalWays = (totalWays)*(totalWays/2);
            }
        }
        long maxDiff = max-min;
        
        output = maxDiff+" "+totalWays;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}