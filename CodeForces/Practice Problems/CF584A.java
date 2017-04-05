import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF584A
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
        int t = Integer.parseInt(st.nextToken());
        if(n==1)
        {
            if(t==10)
                output = "-1";
            else
                output = ""+t;
        }
        else
        {
            if(t==10)
            {
                output = "10";
                for(int i = 0; i < n-2; i++)
                    output += "0";
            }
            else
            {
                output = ""+t;
                for(int i = 0; i < n-1; i++)
                    output += "0";
            }
        }
        
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
