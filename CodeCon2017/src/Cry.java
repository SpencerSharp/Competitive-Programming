import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Cry
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int num = Integer.parseInt(f.readLine());
        
        int maxVal = (int)Math.ceil(Math.sqrt(num));
        
        int total = 0;
        
        int cur = 0;
        
        for(int i = 1; i <= maxVal; i++)
        {
            cur += i*i;
            for(int j = i; j <= maxVal; j++)
            {
                cur += j*j;
                if(cur > num)
                {
                    cur -= j*j;
                    break;
                }
                for(int k = j; k <= maxVal; k++)
                {
                    //out.println(i + " " + j + " " + k);
                    cur += k*k;
                    if(cur > num)
                    {
                        //out.println("BROKEN: " + i + " " + j + " " + k + " CUR: " + cur);
                        cur -= k*k;
                        break;
                    }
                    
                    if(cur==num)
                    {
                        
                        total+=i+j+k;
                    }
                    
                    cur -= k*k;
                }
                cur -= j*j;
            }
            cur -= i*i;
        }
        output = ""+total;
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}