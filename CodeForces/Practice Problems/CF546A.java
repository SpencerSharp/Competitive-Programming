import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF546A
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
        long k = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        
        long money = 0;
        for(int i = 0; i < w; i++)
        {
            money += (i+1)*k;
        }
        money -= n;
        if(money<0)
            money = 0;
        output = ""+money;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}