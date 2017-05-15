import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF149A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        PriorityQueue<Integer> heights = new PriorityQueue<Integer>(12, Collections.reverseOrder());
        int k = Integer.parseInt(f.readLine());
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < 12; i++)
            heights.add(Integer.parseInt(st.nextToken()));
        int curK = 0;
        while(heights.size() > 0 && curK < k)
            curK += heights.poll();
        output = ""+(12 - heights.size());
        if(curK < k && heights.size()==0)
            output = "-1";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
