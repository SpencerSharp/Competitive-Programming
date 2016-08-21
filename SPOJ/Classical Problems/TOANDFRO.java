import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class TOANDFRO
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        //Code here
        int numCols = Integer.parseInt(f.readLine());
        
        while(numCols !=0)
        {
            String line = f.readLine();
            int numRows = line.length()/numCols;
            char[][] ray = new char[numRows][numCols];
            int index = 0;
            for(int r = 0; r < numRows; r++)
            {
                if(r%2==0)
                {
                    for(int c = 0; c < numCols; c++)
                    {
                        ray[r][c] = line.charAt(index++);
                    }
                }
                else
                {
                    for(int c = numCols-1; c >= 0; c--)
                    {
                        ray[r][c] = line.charAt(index++);
                    }
                }
            }
            for(int c = 0; c < numCols; c++)
            {
                for(int r = 0; r < numRows; r++)
                {
                    writer.print(ray[r][c]);
                }
            }
            writer.println();
            numCols = Integer.parseInt(f.readLine());
        }
        
        
        
        
        //Code here
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
