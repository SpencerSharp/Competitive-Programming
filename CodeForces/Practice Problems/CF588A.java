import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF588A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long numDays = Long.parseLong(f.readLine());
        String line;
        StringTokenizer st;
        int[] prices = new int[(int)numDays];
        int[] meatAmounts = new int[(int)numDays];
        int a;
        int p;
        int curPrice = Integer.MAX_VALUE;
        long total = 0;
        for(int i = 0; i < numDays; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            if(p < curPrice)
                curPrice = p;
            total += curPrice * a;
            /*for(int j = i; j < numDays; j++)
            {
                if(prices[j]==0 || prices[j]>p)
                    prices[j] = p;
            }
            meatAmounts[i] = a;*/
        }
        //out.println(disp1d(prices));
        //out.println(disp1d(meatAmounts));
        /*long total = 0;
        for(int i = 0; i < numDays; i++)
        {
            total += prices[i]*meatAmounts[i];
        }*/
        output = ""+total;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static String disp1d(int[] ray)
    {
        String s = "";
        for(int n : ray)
            s += n + " ";
        return s;
    }
}