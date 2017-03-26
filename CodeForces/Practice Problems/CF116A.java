import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF116A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numLines = Integer.parseInt(f.readLine());
        int maxTotal = 0;
        int total = 0;
        String line;
        StringTokenizer st;
        for(int i = 0; i < numLines; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            int leaving = Integer.parseInt(st.nextToken());
            int coming = Integer.parseInt(st.nextToken());
            total -= leaving;
            total += coming;
            if(total > maxTotal)
                maxTotal = total;
        }
        output = ""+maxTotal;
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
