import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF732B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line;
        StringTokenizer st;
        
        line = f.readLine();
        st = new StringTokenizer(line);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] startRay = new int[n];
        
        line = f.readLine();
        st = new StringTokenizer(line);
        
        for(int i = 0; i < n; i++)
        {
            startRay[i] = Integer.parseInt(st.nextToken());
        }
        
        int totalAdded = 0;
        int prev = startRay[0];
        for(int i = 1; i < n; i++)
        {
            int cur = startRay[i];
            int needed = k - (cur + prev);
            if(needed > 0)
            {
                cur += needed;
                totalAdded += needed;
            }
            
            prev = cur;
            startRay[i] = cur;
        }
        
        output += totalAdded + "\n";
        
        for(int num : startRay)
        {
            output += num + " ";
        }
        
        output = output.substring(0,output.length()-1);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}