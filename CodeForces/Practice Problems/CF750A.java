import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF750A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int total = 240;
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        total -= k;
        int numSolved = 0;
        while(total > 0 && numSolved < n)
        {
            total -= (++numSolved)*5;
        }
        if(total>=0)
            numSolved++;
        output = ""+(numSolved-1);
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
