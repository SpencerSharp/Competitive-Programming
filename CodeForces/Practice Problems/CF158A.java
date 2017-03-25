import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF158A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String nk = f.readLine();
        StringTokenizer st = new StringTokenizer(nk);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String line = f.readLine();
        st = new StringTokenizer(line);
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int kScore = nums[k-1];
        int total = 0;
        for(int i = 0; i < n; i++)
            if(nums[i]>=kScore && nums[i]>0)
                total++;
        
        output = ""+total;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
