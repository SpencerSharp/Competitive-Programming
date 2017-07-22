import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF515A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        long minSteps = Math.abs(Long.parseLong(st.nextToken()));
        minSteps += Math.abs(Long.parseLong(st.nextToken()));
        
        long s = Long.parseLong(st.nextToken());
        
        if(s<minSteps)
            output = "No";
        else if(s%2==0)
        {
            if(minSteps%2==0)
            {
                output = "Yes";
            }
            else
            {
                output = "No";
            }
        }
        else
        {
            if(minSteps%2==0)
            {
                output = "No";
            }
            else
            {
                output = "Yes";
            }
        }
        
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}