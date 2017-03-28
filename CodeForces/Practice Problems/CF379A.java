import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF379A
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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int wentOut = 0;
        int hours = 0;
        while(a > 0)
        {
            a--;
            wentOut++;
            if(wentOut==b)
            {
                a++;
                wentOut = 0;
            }
            hours++;
        }
        output = ""+hours;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
