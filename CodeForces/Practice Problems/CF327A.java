import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF327A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numNums = Integer.parseInt(f.readLine());
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int[] nums = new int[numNums];
        for(int i = 0; i < numNums; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        int max = -1;
        for(int i = 0; i < numNums; i++)
            for(int j = i; j < numNums; j++)
            {
                int count = 0;
                int cur = 0;
                for(int index = 0; index < numNums; index++)
                {
                    if(index >= i && index <= j)
                    {
                        cur = 1-nums[index];
                    }
                    else
                        cur = nums[index];
                    count += cur==1?1:0;
                }
                if(count > max)
                    max = count;
            }
        output = ""+max;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
