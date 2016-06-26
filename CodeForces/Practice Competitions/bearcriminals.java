import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class bearcriminals
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
        int numCities = Integer.parseInt(st.nextToken());
        int limakInd = Integer.parseInt(st.nextToken())-1;
        int[] cities = new int[numCities];
        
        line = f.readLine();
        st = new StringTokenizer(line);
        for(int i = 0; i < numCities; i++)
            cities[i]=Integer.parseInt(st.nextToken());
        
        int totalSure = 0;
        for(int i = 0; i <= (numCities/2)+2; i++)
        {
            int numSure = numSureCriminalsForBCDValue(cities,i,limakInd);
            totalSure += numSure;
            //out.println(i + " " + numSure);
        }
        
        output += totalSure;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int numSureCriminalsForBCDValue(int[] ray, int BCD, int limak)
    {
        int ind1 = limak+BCD;
        int ind2 = limak-BCD;
        if(BCD==0)
        {
            if(ray[ind1]==1)
                return 1;
            else
                return 0;
        }
        if(ind1 < 0 || ind1 >= ray.length)
        {
            if(ind2 < 0 || ind2 >= ray.length) //Neither in bounds
            {
                return 0;
            }
            else //ind1 not ind2 good
            {
                if(ray[ind2]==1)
                    return 1;
                else
                    return 0;
            }
        }
        else if(ind2 < 0 || ind2 >= ray.length) //ind1 good ind2 not
        {
            if(ray[ind1]==1)
                return 1;
            else
                return 0;
        }
        else //Both in bounds
        {
            if(ray[ind1]==1 && ray[ind2]==1)
                return 2;
            else
                return 0;
        }
    }
}
