import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class bearcards
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        int[] ray = new int[5];
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < 5; i++)
            ray[i] = Integer.parseInt(st.nextToken());
        
        int deleteNum = getNumToDelete(ray);
        
        int sum = 0;
        int count = 0;
            for(int i = 0; i < 5; i++)
            {
                if(ray[i]!=deleteNum || count>=3)
                {
                    sum += ray[i];
                }
                else
                    count++;
            }
        
        output += sum;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getNumToDelete(int[] ray)
    {
        int maxTotal = 0;
        int num = -1;
        for(int i = 0; i < 5; i++)
        {
            int curNum = ray[i];
            int totCount = 0;
            for(int j = 0; j < ray.length; j++)
            {
                if(ray[j]==ray[i])
                    totCount++;
            }
            if(totCount>3)
                return curNum;
            else
            {
                if(totCount>1)
                {
                    int n = totCount * curNum;
                    if(n > maxTotal)
                    {
                        maxTotal = n;
                        num = curNum;
                    }
                }
            }
        }
        return num;
    }
}