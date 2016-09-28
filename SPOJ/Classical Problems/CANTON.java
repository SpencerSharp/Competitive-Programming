import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CANTON
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long startNano = System.nanoTime();
        int total = 0;
        int curNum = 2;
        long[] totals = new long[4500];
        while(totals[curNum-1] < Math.pow(10,7))
        {
            totals[curNum] = totals[curNum-1];
            totals[curNum]+=curNum-1;
            //out.println(totals[curNum]);
            curNum++;
        }
        //out.println(totals[curNum-1]);
        long endNano  =System.nanoTime();
        
        //out.println(nanosToSeconds(endNano-startNano));
        //out.println(curNum);
        int numCases = Integer.parseInt(f.readLine());
        for(int numLoops = 0; numLoops < numCases; numLoops++)
        {
            int num = Integer.parseInt(f.readLine());
            int index = 1;
            for(int ind = curNum-1; ind >= 2; ind--)
            {
                if(totals[ind]<num)
                {
                    index = ind;
                    break;
                }
            }
            String result;
            if(index==1)
                result = "1/1";
            else
            {
                if(index%2==0)
                {
                    
                    int num1 = (int)num - (int)totals[index];
                    int num2 = (index+1)-num1;
                    result = num1 + "/" + num2;
                }
                else
                {
                    int num1 = (int)num - (int)totals[index];
                    int num2 = (index+1)-num1;
                    result = num2 + "/" + num1;
                }
            }
            writer.println("TERM " + num + " IS " + result);
        }
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static double nanosToSeconds(long nanos)
    {
        double seconds = nanos / 1000000000.0;
        return seconds;
    }
}
