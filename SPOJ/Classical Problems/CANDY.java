import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CANDY
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        ArrayList<Integer> candies = new ArrayList<Integer>();
        int size = Integer.parseInt(f.readLine());
        while(size !=-1)
        {
            int sum = 0; 
            for(int i = 0; i < size; i++)
            {
                int cur = Integer.parseInt(f.readLine());
                candies.add(cur);
                sum += cur;
            }
            if(sum%size!=0)
            {
                writer.println(-1);
            }
            else
            {
                int moves = 0;
                if(getPair(sum/size)!=null)
                {
                    
                }
                else
                {
                    give(min,max);
                }
            }
        }
        
        
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
        
    }
}
