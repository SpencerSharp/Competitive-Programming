import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF158B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numGroups = Integer.parseInt(f.readLine());
        int[] totals = new int[4];
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < numGroups; i++)
            totals[Integer.parseInt(st.nextToken())-1]++;
        //Put all 1s with 3s
        //Then put all 2s with 2s
        //Then put all 1s with 2s
        //Then put all 1s together
        if(totals[3-1] >= totals[1-1])
            totals[1-1] = 0;
        else
        {
            totals[1-1] -= totals[3-1];
        }
        if(totals[2-1]%2==0)
            totals[2-1]/=2;
        else
        {
            totals[2-1] /= 2;
            totals[2]++;
            if(totals[1-1]<=2)
                totals[1-1] = 0;
            else
                totals[1-1]-=2;
        }
        if(totals[1-1]%4==0)
            totals[1-1]/=4;
        else
        {
            totals[1-1]/=4;
            totals[1-1]++;
        }
        output = ""+ (totals[0] + totals[1] + totals[2] + totals[3]);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
