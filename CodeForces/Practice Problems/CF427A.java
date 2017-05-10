import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF427A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numThings = Integer.parseInt(f.readLine());
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int total = 0;
        int unsolved = 0;
        while(st.hasMoreTokens())
        {
            int num = Integer.parseInt(st.nextToken());
            if(num==-1)
            {
                if(total==0)
                {
                    unsolved++;
                }
                else
                {
                    total += num;
                }
            }
            else
            {
                total += num;
            }
        }
        output = ""+unsolved;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
