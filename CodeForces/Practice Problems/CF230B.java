import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF230B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        
        int max = (int)Math.sqrt(Math.pow(10,12));
        int[] nums = new int[(int)Math.sqrt(Math.pow(10,12))+1];
        HashSet<Long> results = new HashSet<Long>();
        results.add(4l);
        for(int num = 3; num <= max; num+=2)
        {
            if(nums[num]!=-1)
            {
                results.add((long)num*num);
                for(int num2 = num * 2; num2 <= max; num2 += num)
                {
                    nums[num2] = -1;
                }
            }
        }
        
        int numNums = Integer.parseInt(f.readLine());
        
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        while(st.hasMoreTokens())
        {
            writer.println(results.contains(Long.parseLong(st.nextToken()))?"YES":"NO");
        }
        /*
        long total = 0;
        while(total*total < Math.pow(10,12))
        {
            total++;
        }
        out.println(total);
        //Code here
        int numNums = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < numNums; i++)
        {
            long n = Long.parseLong(st.nextToken());
            double root = Math.sqrt(n);
            String result = "";
            if(n==1)
                result = "NO";
            else if(Math.round(root) == root)
            {
                int cur = 1;
                for(long d = 2; d < Math.sqrt(n); d++)
                {
                    if(n%d==0)
                    {
                        cur = 0;
                        break;
                    }
                }
                //out.println(n + " " + cur);
                if(cur==1)
                    result = "YES";
                else
                    result = "NO";
            }
            else
                result = "NO";
            
            //writer.println(result);
        }
        */
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
