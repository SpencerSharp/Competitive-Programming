import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF266B
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
        int t = Integer.parseInt(st.nextToken());
        String q = f.readLine();
        for(int i = 0; i < t; i++)
        {
            ArrayList<Integer> bsToSwapBack = new ArrayList<Integer>();
            for(int j = 0; j < q.length()-1; j++)
            {
                if(q.charAt(j)=='B'&&q.charAt(j+1)=='G')
                    bsToSwapBack.add(j);
            }
            for(int b : bsToSwapBack)
            {
                q = q.substring(0,b) + "GB" + q.substring(b+2);
            }
        }
        output = q;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
