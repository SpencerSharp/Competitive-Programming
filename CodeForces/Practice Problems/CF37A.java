import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF37A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numBoards = Integer.parseInt(f.readLine());
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int[] towers = new int[1000];
        
        for(int i = 0; i < numBoards; i++)
        {
            int board = Integer.parseInt(st.nextToken());
            towers[board-1]++;
        }
        
        int max = 0;
        int numTowers = 0;
        
        for(int i = 0; i < 1000; i++)
        {
            if(towers[i]>0)
            {
                if(towers[i]>max)
                    max = towers[i];
                numTowers++;
            }
        }
        
        output = max + " " + numTowers;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}