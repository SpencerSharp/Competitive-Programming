import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class TIMUS1225
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String output = ""; //Write all output to this string

        //Code here
        int input = Integer.parseInt(f.readLine());
        long[] nums = new long[46];
        nums[1] = 2;
        nums[2] = 2;
        for(int i = 3; i <= 45; i++)
        {
            nums[i] = nums[i-1] + nums[i-2];
        }
        
        //Code here

        out.println(nums[input]);
    }
    
    public static long bruteForcePosFlags(int len, String s)
    {
        int sLength = s.length();
        if(s.length()==len)
        {
            //out.println(s);
            return 1;
        }
        else
        {
            long total = 0;
            if(sLength==0)
            {
                total += bruteForcePosFlags(len,s+"w");
                total += bruteForcePosFlags(len,s+"r");
            }
            else
            {
                char lastChar = s.charAt(sLength-1);
                if(lastChar=='b')
                {
                    char prevChar = s.charAt(sLength-1);
                    if(prevChar=='w')
                    {
                        total += bruteForcePosFlags(len, s+"r");
                    }
                    else
                    {
                        total += bruteForcePosFlags(len, s+"w");
                    }
                }
                else
                {
                    if(sLength!=len-1)
                    {
                        total += bruteForcePosFlags(len,s+"b");
                    }
                    if(lastChar=='w')
                    {
                        total += bruteForcePosFlags(len,s+"r");
                    }
                    else
                    {
                        total += bruteForcePosFlags(len,s+"w");
                    }
                }
            }
            return total;
        }
    }
}
