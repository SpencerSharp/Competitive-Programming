/*
ID: spencer16
LANG: JAVA
PROG: Railroad
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Railroad
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("Railroad.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Railroad.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int numCases = Integer.parseInt(f.readLine());
        for(int curLoop = 0; curLoop < numCases; curLoop++)
        {
            //out.println("loop"+curLoop);
            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            byte[] rows = new byte[(int)n];
            byte[] cols = new byte[(int)m];
            int plats = Integer.parseInt(st.nextToken());
            for(int plat = 0; plat < plats; plat++)
            {
                //out.println("plat"+plat);
                line = f.readLine();
                st = new StringTokenizer(line);
                int startRow = Integer.parseInt(st.nextToken());
                int startCol = Integer.parseInt(st.nextToken());
                int width = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                for(int i = startRow; i < startRow+width; i++)
                    rows[i] = 1;
                for(int i = startCol; i < startCol+height; i++)
                    cols[i] = 1;
            }
            int total = 0;
            for(byte num : rows)
            {
                //out.print(num);
                if(num==0)
                    total++;
            }
            //out.println();
            for(byte num : cols)
            {
                //out.print(num);
                if(num==0)
                    total++;
            }
            //out.println();
            writer.println(total);
        }
        
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
