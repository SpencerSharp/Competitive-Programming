/*
ID: spencer16
LANG: JAVA
PROG: milk
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class milk
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int milkNeeded = Integer.parseInt(st.nextToken());
        int numFarmers = Integer.parseInt(st.nextToken());
        TreeMap<Integer,Integer> costs = new TreeMap<Integer,Integer>();
        for(int i = 0; i < numFarmers; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            int milkPrice = Integer.parseInt(st.nextToken());
            int milkAmount = Integer.parseInt(st.nextToken());
            if(costs.get(milkPrice)==null)
                costs.put(milkPrice, milkAmount);
            else
                costs.put(milkPrice,costs.get(milkPrice)+milkAmount);
        }
        int totalCost = 0;
        for(Map.Entry<Integer,Integer> entry : costs.entrySet())
        {
            if(milkNeeded>0)
            {
                int milkPrice = entry.getKey();
                int milkAmount = entry.getValue();
                if(milkAmount>=milkNeeded)
                {
                    totalCost += milkNeeded*milkPrice;
                    milkNeeded=0;
                }
                else
                {
                    totalCost += milkAmount*milkPrice;
                    milkNeeded-=milkAmount;
                }
            }
        }
        output += totalCost;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}