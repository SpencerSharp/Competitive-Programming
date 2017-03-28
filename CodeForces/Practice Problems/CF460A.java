import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF460A
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int day = 1;
        while(n > 0)
        {
            n--;
            if(day%m==0)
                n++;
            day++;
        }
        output = ""+(day-1);
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
