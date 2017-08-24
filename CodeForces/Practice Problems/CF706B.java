import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF706B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        
        int numShops = Integer.parseInt(st.nextToken());
        
        line = f.readLine();
        st = new StringTokenizer(line);
        
        int[] prices = new int[numShops];
        
        for(int i = 0; i < numShops; i++)
        {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(prices);
        
        int[] condensedPrices = new int[numShops];
        Arrays.fill(condensedPrices, 100001);
        int[] numShopsAtOrBelowPrice = new int[numShops];
        Arrays.fill(numShopsAtOrBelowPrice, numShops);
        
        int prev = -1;
        int index = -1;
        
        for(int i = 0; i < numShops; i++)
        {
            int cur = prices[i];
            if(cur!=prev)
            {
                index++;
                condensedPrices[index] = cur;
                if(index > 0)
                {
                    numShopsAtOrBelowPrice[index] = numShopsAtOrBelowPrice[index-1]+1;
                }
                else
                {
                    numShopsAtOrBelowPrice[index] = 1;
                }
                prev = cur;
            }
            else
            {
                numShopsAtOrBelowPrice[index]++;
            }
        }
        
        //for(int i = 0; i < numShops; i++)
        //    out.println(condensedPrices[i]);
        
        line = f.readLine();
        
        int numDays = Integer.parseInt(line);
        
        for(int i = 0; i < numDays; i++)
        {
            long money = Long.parseLong(f.readLine());
            if(money>100000)
            {
                money = 100001;
            }
            int spot = Arrays.binarySearch(condensedPrices, (int)money);
            int result = 0;
            if(spot < 0)
            {
                //out.println("PREFLIPSPOT:"+spot);
                spot = ~spot;
                if(spot==0)
                {
                    result = 0;
                }
                else if(spot > index)
                {
                    //out.println("cat");
                    result = numShops;
                }
                else
                {
                    //out.println("dog");
                    result = numShopsAtOrBelowPrice[spot-1];
                }
            }
            else
            {
                result = numShopsAtOrBelowPrice[spot];
            }
            //out.println("SPOT"+spot);
            writer.println(result);
        }
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}