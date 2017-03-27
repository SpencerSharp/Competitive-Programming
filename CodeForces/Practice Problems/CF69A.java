import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF69A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numVecs = Integer.parseInt(f.readLine());
        int total1 = 0;
        int total2 = 0;
        int total3 = 0;
        String line;
        StringTokenizer st;
        for(int i = 0; i < numVecs; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            total1 += Integer.parseInt(st.nextToken());
            total2 += Integer.parseInt(st.nextToken());
            total3 += Integer.parseInt(st.nextToken());
        }

        output = total1==0&&total2==0&&total3==0?"YES":"NO";
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
