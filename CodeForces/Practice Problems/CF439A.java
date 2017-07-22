import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF439A
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
        int d = Integer.parseInt(st.nextToken());
        
        int[] songLengths = new int[n];
        
        line = f.readLine();
        st = new StringTokenizer(line);
        
        int lengthTotal = 0;
        
        for(int i = 0; i < n; i++)
        {
            int s = Integer.parseInt(st.nextToken());
            songLengths[i] = s;
            lengthTotal += s;
        }
        
        int songTotal = lengthTotal + ((n-1)*10);
        
        if(songTotal <= d)
        {
            int additionalJokes = (d-songTotal)/5;
            int totalJokes = additionalJokes + (n-1)*2;
            writer.println(totalJokes);
        }
        else
        {
            writer.println(-1);
        }
        
        
        
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
