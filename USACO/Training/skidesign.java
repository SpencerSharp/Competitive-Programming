/*
ID: spencer16
LANG: JAVA
PROG: skidesign
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class skidesign
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int numHills = Integer.parseInt(f.readLine());
        ArrayList<Integer> hills = new ArrayList<Integer>();
        for(int i = 0; i < numHills; i++)
            hills.add(Integer.parseInt(f.readLine()));
        
        ArrayList<Integer> costs = new ArrayList<Integer>();
        for(int h = 0; h < 100-17; h++)
        {
            int totalCost = 0;
            int min = h;
            int max = h + 17;
            for(int i = 0; i < hills.size(); i++)
            {
                int height = hills.get(i);
                if(height < min)
                {
                    int diff = min - height;
                    totalCost += diff * diff;
                }
                if(height > max)
                {
                    int diff = height - max;
                    totalCost += diff*diff;
                }
            }
            costs.add(totalCost);
        }
        int minCost = costs.get(0);
        for(int i = 0; i < costs.size(); i++)
            if(costs.get(i) < minCost)
                minCost = costs.get(i);
        output += minCost;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
    }
}