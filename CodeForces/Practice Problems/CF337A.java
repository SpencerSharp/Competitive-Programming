import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF337A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line;
        StringTokenizer st;
        line = f.readLine();
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        line = f.readLine();
        st = new StringTokenizer(line);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i =0; i < m; i++)
            nums.add(Integer.parseInt(st.nextToken()));
        Collections.sort(nums);
        //out.println(nums);
        int min = nums.get(nums.size()-1) - nums.get(nums.size()-1-(n-1));
        for(int i = 0; i < nums.size()-1-(n-1); i++)
        {
            int num = nums.get(i+n-1) - nums.get(i);
            if(num < min)
                min = num;
        }
        //Code here

        //out.println(min);
        
        writer.println(min);
        writer.close();
        System.exit(0);
        
    }
}
