import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF469A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numLevels = Integer.parseInt(f.readLine());
        int[] nums = new int[numLevels];
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int numLevelsX = Integer.parseInt(st.nextToken());
        for(int i = 0; i < numLevelsX; i++)
        {
            int n = Integer.parseInt(st.nextToken());
            nums[n-1]++;
        }
        line = f.readLine();
        st = new StringTokenizer(line);
        int numLevelsY = Integer.parseInt(st.nextToken());
        for(int i = 0; i < numLevelsY; i++)
        {
            int n = Integer.parseInt(st.nextToken());
            nums[n-1]++;
        }
        boolean isBeatable = true;
        for(int i = 0; i < numLevels; i++)
        {
            if(nums[i]==0)
                isBeatable = false;
        }
        output = isBeatable?"I become the guy.":"Oh, my keyboard!";
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
