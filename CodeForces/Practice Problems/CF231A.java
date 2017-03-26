import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF231A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st;
        int size = Integer.parseInt(line);
        int[] totals = new int[size];
        for(int i = 0; i < size; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            for(int j = 0; j < 3; j++)
            {
                totals[i] += Integer.parseInt(st.nextToken());
            }
        }
        int numSolved = 0;
        for(int n : totals)
            if(n>=2)
                numSolved++;
        output = ""+numSolved;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
