import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF271A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int input = Integer.parseInt(f.readLine());
        
        for(int i = input+1; i <= Integer.MAX_VALUE; i++)
        {
            if(isDistinct(i))
            {
                output = ""+i;
                break;
            }
        }
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean isDistinct(int n)
    {
        String l = ""+n;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < l.length(); i++)
        {
            int cur = Integer.parseInt(""+l.charAt(i));
            for(int j = 0; j < nums.size(); j++)
            {
                if(cur==nums.get(j))
                    return false;
            }
            nums.add(cur);
        }
        return true;
    }
}