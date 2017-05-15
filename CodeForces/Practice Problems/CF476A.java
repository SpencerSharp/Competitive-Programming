import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF476A
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
        int num = Integer.parseInt(st.nextToken());
        int multiple = Integer.parseInt(st.nextToken());
        int min = (num+1)/2;
        int max = num;
        int found = -1;
        for(int i = min; i <= max; i++)
        {
            if(i % multiple == 0)
            {
                found = i; break;
            }
        }
        output = ""+found;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
