import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF791A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        long limak = Long.parseLong(st.nextToken());
        long bob = Long.parseLong(st.nextToken());
        
        long year = 0;
        
        while(bob>=limak)
        {
            bob*=2;
            limak*=3;
            year++;
        }
        
        output = ""+year;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}