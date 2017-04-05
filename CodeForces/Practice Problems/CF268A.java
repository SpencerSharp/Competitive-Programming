import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF268A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        int[][] map = new int[n][2];
        String line;
        StringTokenizer st;
        for(int i = 0; i < n; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[i][0] = n1;
            map[i][1] = n2;
        }
        int total = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i!=j)
                {
                    if(map[i][0]==map[j][1])
                        total++;
                }
            }
        }
        output = ""+total;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
