import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF237A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numCustomers = Integer.parseInt(f.readLine());
        
        int max = 1;
        int streak = 1;
        
        String line;
        StringTokenizer st;
        int prevH = -1;
        int prevM = -1;
        for(int i = 0; i < numCustomers; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            
            int curH = Integer.parseInt(st.nextToken());
            int curM = Integer.parseInt(st.nextToken());
            
            if(curH==prevH && curM==prevM)
            {
                streak++;
            }
            else
            {
                prevH = curH;
                prevM = curM;
                max = Math.max(max,streak);
                streak = 1;
            }
        }
        
        max = Math.max(max,streak);
        
        output = ""+max;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}