import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CANDY3
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numCases = Integer.parseInt(f.readLine());
        f.readLine();
        String line;
        BigInteger zero = new BigInteger("0");
        for(int i = 0; i < numCases; i++)
        {
            BigInteger total = new BigInteger("0");
            int numChildren = Integer.parseInt(f.readLine());
            BigInteger numChildrenBig = new BigInteger(""+numChildren);
            for(int n = 0; n < numChildren; n++)
            {
                total = total.add(new BigInteger(f.readLine()));
            }
            if(total.mod(numChildrenBig).equals(zero))
                writer.println("YES");
            else
                writer.println("NO");
            
            //out.println();
            if(i!=numCases-1)
                line = f.readLine();
        }
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
    }
}
