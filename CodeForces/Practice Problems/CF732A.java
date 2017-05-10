import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF732A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numShovels = 0;
        boolean foundNumToBuy = false;
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int price = Integer.parseInt(st.nextToken());
        int singleCoin = Integer.parseInt(st.nextToken());
        while(!foundNumToBuy && numShovels < 9)
        {
            numShovels++;
            int totalPrice = price*numShovels;
            if(totalPrice%10==0 || (totalPrice-singleCoin)%10==0)
                foundNumToBuy = true;
        }
        if(!foundNumToBuy)
            numShovels = 10;
        output = ""+numShovels;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
