import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF719A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numDays = Integer.parseInt(f.readLine());
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        if(numDays==1)
        {
            int num = Integer.parseInt(st.nextToken());
            if(num==15)
                output = "DOWN";
            else if(num==0)
                output = "UP";
            else
                output = "-1";
        }
        else
        {
            for(int i = 0; i < numDays-2; i++)
            {
                st.nextToken();
            }
            int prev = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            if(prev > cur)
            {
                if(cur==0)
                {
                    output = "UP";
                }
                else
                {
                    output = "DOWN";
                }
            }
            else if(cur > prev)
            {
                if(cur==15)
                {
                    output = "DOWN";
                }
                else
                {
                    output = "UP";
                }
            }
        }
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}