import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF160A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numCoins = Integer.parseInt(f.readLine());
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        ArrayList<Integer> coins = new ArrayList<Integer>();
        int total = 0;
        for(int i = 0; i < numCoins; i++)
        {
            int coin = Integer.parseInt(st.nextToken());
            total += coin;
            coins.add(coin);
        }
        Collections.sort(coins,Collections.reverseOrder());
        int myTotal = 0;
        while(myTotal <= total)
        {
            int coin = coins.remove(0);
            myTotal += coin;
            total -= coin;
        }
        output =""+ (numCoins - coins.size());
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
