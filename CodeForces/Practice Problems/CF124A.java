import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF124A
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
        
        int total = Integer.parseInt(st.nextToken())-1;
        int minBefore = Integer.parseInt(st.nextToken());
        int maxAfter = Integer.parseInt(st.nextToken());
        
        int result = 0;
        
        for(int i = 1; i <= total+1; i++)
        {
            int numBefore = i-1;
            int numAfter = total-numBefore;
            //out.println(numBefore + " " + numAfter);
            if(numAfter <= maxAfter && minBefore <= numBefore)
            {
                result++; //out.println("yes");
            }
        }
        
        output = ""+result;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}