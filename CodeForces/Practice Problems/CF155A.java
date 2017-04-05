import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF155A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numNums = Integer.parseInt(f.readLine());
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int min = Integer.parseInt(st.nextToken());
        int max = min;
        int amazing = 0;
        for(int i = 0; i < numNums-1; i++)
        {
            int n = Integer.parseInt(st.nextToken());
            if(n > max)
            {
                max = n;
                amazing++;
            }
            else if(n < min)
            {
                min = n;
                amazing++;
            }
        }
        output = ""+amazing;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
