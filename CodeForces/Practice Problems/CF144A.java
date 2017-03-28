import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF144A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numS = Integer.parseInt(f.readLine());
        String line = f.readLine();
        ArrayList<Integer> solds = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < numS; i++)
        {
            solds.add(Integer.parseInt(st.nextToken()));
        }
        int indexOfLastMin = 0;
        int min = solds.get(0);
        for(int i = 0; i < numS; i++)
        {
            if(solds.get(i) <= min)
            {
                min = solds.get(i);
                indexOfLastMin = i;
            }
        }
        int indexOfFirstMax = 0;
        int max = solds.get(0);
        for(int i = 0; i < numS; i++)
        {
            if(solds.get(i) > max)
            {
                max = solds.get(i);
                indexOfFirstMax = i;
            }
        }
        //out.println(indexOfFirstMax);
        int total = indexOfFirstMax + ((numS-1)-indexOfLastMin);
        if(indexOfFirstMax > indexOfLastMin)
            total--;
        output = ""+total;  
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
