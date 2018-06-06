import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF735A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        int numCells = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        String line = f.readLine();
        
        int g = 0;
        int t = 0;
        
        for(int i = 0; i < numCells; i++)
        {
            if(line.charAt(i) == 'G')
            {
                g = i;
            }
            else if(line.charAt(i) == 'T')
            {
                t = i;
            }
        }
        
        if(g > t)
        {
            while(g > t && line.charAt(g) != '#')
            {
                g -= k;
            }
        }
        else
        {
            while(g < t && line.charAt(g) != '#')
            {
                g += k;
            }
        }
        
        if(g == t)
        {
            output = "YES";
        }
        else
        {
            output = "NO";
        }
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}