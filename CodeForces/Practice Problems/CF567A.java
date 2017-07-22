import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF567A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numCities = Integer.parseInt(f.readLine());
        
        long[] cities = new long[numCities];
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        for(int i = 0; i < numCities; i++)
        {
            cities[i] = Long.parseLong(st.nextToken());
        }
        
        for(int i = 0; i < numCities; i++)
        {
            long min = 0;
            long max = 0;
            if(i==0)
            {
                min = cities[1]-cities[0];
                max = cities[numCities-1]-cities[0];
            }
            else if(i==numCities-1)
            {
                min = cities[numCities-1]-cities[numCities-2];
                max = cities[numCities-1]-cities[0];
            }
            else
            {
                min = Math.min(cities[i+1]-cities[i],cities[i]-cities[i-1]);
                max = Math.max(cities[i]-cities[0],cities[numCities-1]-cities[i]);
            }
            writer.println(min + " " + max);
        }
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
