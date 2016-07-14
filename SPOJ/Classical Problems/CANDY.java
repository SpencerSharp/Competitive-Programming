import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CANDY
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int size = Integer.parseInt(f.readLine());
        
        while(size !=-1)
        {
            long[] candies = new long[size+1];
            long sum = 0; 
            for(int i = 0; i < size; i++)
            {
                long cur = Long.parseLong(f.readLine());
                candies[i]=cur;
                sum += cur;
            }
            if(sum%size!=0)
            {
                writer.println(-1);
            }
            else
            {
                long moves = 0;
                for(int i = 0; i < candies.length; i++)
                {
                    if(candies[i]>(sum/size))
                        moves+=(candies[i]-(sum/size));
                }
                writer.println(moves);
            }
            size = Integer.parseInt(f.readLine());
        }
        
        
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
    }
    
    public static boolean isUniform(ArrayList<Integer> candies, int supposedToEqual)
    {
        for(int n : candies)
            if(n!=supposedToEqual)
                return false;
        return true;
    }
    
    public static String getPair(ArrayList<Integer> candies, int supposedToEqual)
    {
        return null;
    }
}