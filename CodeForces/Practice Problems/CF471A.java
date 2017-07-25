import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF471A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int[] nums = new int[10];
        
        for(int i = 0; i < 6; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            nums[num]++;
        }
        
        int indexOfLegs = -1;
        
        for(int i = 1; i < 10; i++)
        {
            if(nums[i] >= 4)
                indexOfLegs = i;
        }
        
        if(indexOfLegs==-1)
            output = "Alien";
        else
        {
            nums[indexOfLegs]-=4;
            boolean num1found = false;
            
            int num1 = -1;
            int num2 = -1;
            
            for(int i = 0; i < 10; i++)
            {
                if(nums[i]==2)
                {
                    num1 = i;
                    num2 = i;
                }
                else if(nums[i]==1)
                {
                    if(num1found)
                        num2 = i;
                    else
                    {
                        num1 = i;
                        num1found = true;
                    }
                }
            }
            
            if(num1==num2)
                output = "Elephant";
            else
                output = "Bear";
        }
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}