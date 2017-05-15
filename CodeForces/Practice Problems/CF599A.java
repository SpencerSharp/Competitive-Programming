import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF599A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        
        //Options are:
        //2x D1, 2x D2
        //2x D1, 2x D3
        //2x D2, 2x D3
        //1x D1, 1x D2, 1x D3
        
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        BigInteger d1 = new BigInteger(st.nextToken());
        BigInteger d2 = new BigInteger(st.nextToken());
        BigInteger d3 = new BigInteger(st.nextToken());
        
        BigInteger op1 = d1.add(d1.add(d2.add(d2)));
        BigInteger op2 = d1.add(d1.add(d3.add(d3)));
        BigInteger op3 = d2.add(d2.add(d3.add(d3)));
        BigInteger op4 = d1.add(d2.add(d3));
        
        output = ""+op1.min(op2.min(op3.min(op4)));
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
