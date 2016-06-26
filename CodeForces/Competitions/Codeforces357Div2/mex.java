import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class mex
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        long size = Long.parseLong(st.nextToken());
        //out.println(size);
        int maxNum = (int)Math.pow(10,9)+1;
        String nums = "";
        for(int i = 0; i < maxNum; i++)
            nums += 0;
        line = f.readLine();
        st = new StringTokenizer(line);
        int max = 0;
        for(int i = 1; i <= size; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            if(num > max)
                max = num;
            int indexVal = Integer.parseInt(""+nums.charAt(num));
            nums = nums.substring(0,num) + indexVal + nums.substring(num+1);
        }
        out.println(nums);
        
        int atOrAbove = (int)size;
        int numToSubtract = 0;
        for(int i = 1; i <= max; i++)
        {
            if(atOrAbove==0)
            {
                output += i;
                break;
            }
            if(Integer.parseInt(""+nums.charAt(i))>0)
            {
                if(numToSubtract >0)
                {
                    if(Integer.parseInt(""+nums.charAt(i))>=numToSubtract)
                    {
                        nums[i]-=numToSubtract;
                        atOrAbove-=nums[i];
                        numToSubtract = 0;
                    }
                    else
                    {
                        numToSubtract-=nums[i];
                        nums[i]=0;
                    }
                }
                else
                    atOrAbove -= nums[i];
            }
            else
            {
                atOrAbove--;
                numToSubtract++;
            }
        }
        //out.println(nums);
        
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static TreeMap<Long,Long> shiftNextDown(TreeMap<Long,Long> nums,long num,long max)
    {
        boolean operationCompleted = false;
        for(long i = num+1;i<=max;i++)
        {
            try
            {
                if(!operationCompleted)
                {
                long n = nums.get(i);
                if(n>=1)
                {
                nums.put(i,nums.get(i)-1);
                nums.put(num,1l);
                operationCompleted = true;
                }
                }
            }
            catch(Exception e)
            {
                
            }
        }
        //out.println(nums);
        if(!operationCompleted)
            return null;
        else
            return nums;
    }
}