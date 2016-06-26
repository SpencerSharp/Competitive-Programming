import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class FCTRL
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        long start = System.nanoTime();
        //Code here
        int size = Integer.parseInt(f.readLine());
        //out.println(size);
        for(int n = 0; n < size; n++)
        {
            int num = Integer.parseInt(f.readLine());
            long numZeros = getNumZeros(num,5);
            writer.println(numZeros);
        }
        //output = output.substring(0,output.length()-1);
        //long end = System.nanoTime();
        //out.println(((end-start)*(100000/5))/1000000000);
        
        //Code here

        //writer.println(output);
        writer.close();
        System.exit(0);
    }

    public static long getNumZeros(int num, int numPowed)
    {
        if(num<numPowed)
            return 0;
        else
            return num/numPowed + getNumZeros(num,numPowed*5);
    }
}
