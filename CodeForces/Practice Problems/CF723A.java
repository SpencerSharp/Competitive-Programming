import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF723A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        String[] nums = line.split(" ");
        int min = 300;
        for(int i = 1; i <= 100; i++)
        {
            int distToTravel = getTotalDist(nums,i);
            if(distToTravel<min)
                min = distToTravel;
        }
        output = ""+min;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getTotalDist(String[] ray, int end)
    {
        int ret = 0;
        for(String s : ray)
        {
            int n = Integer.parseInt(s);
            ret += Math.abs(n-end);
        }
        return ret;
    }
}