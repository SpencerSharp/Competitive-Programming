import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF716A
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
        int c = Integer.parseInt(st.nextToken());
        
        line = f.readLine();
        st = new StringTokenizer(line);
        
        int prevTime = 0;
        int curTime;
        int numWords = 0;
        
        if(n>0)
        {
            prevTime = Integer.parseInt(st.nextToken());
            numWords++;
        }
        for(int i = 1; i < n; i++)
        {
            curTime = Integer.parseInt(st.nextToken());
            if(curTime-prevTime <= c)
                numWords++;
            else
                numWords = 1;
            prevTime = curTime;
        }
        
        output = ""+numWords;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
