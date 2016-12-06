import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class bearblocks
{
    public static void main(String[] args) throws IOException
    {
        long start = System.nanoTime();
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        //ArrayList<Long> cubesLessThanTenToFifteenth = genCubes();
        //out.println(cubesLessThanTenToFifteenth.get(0));
        long maxVol = Long.parseLong(f.readLine());
        long volFound = 1;
        long maxBlocks = 1;
        for(long n = maxVol; n >= maxVol-20000000 && n >=0; n--)
        {
            long blocks = getNumBlocksFromLimak(n);
            //out.println(n);
            if(blocks > maxBlocks)
            {
                maxBlocks = blocks;
                volFound = n;
            }
        }
        output += maxBlocks + " " + volFound;
        
        
        //Code here
        long end = System.nanoTime();
        writer.println(output);
        //out.println((((double)(end-start)))/1000000000);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getNumBlocksFromLimak(long n)
    {
        //out.println("yo"+n);
        long num = (long) Math.cbrt(n);
        //out.println(num);
        long cubed = num * num * num;
        //out.println(cubed);
        if(num >= 1)
            return 1 + getNumBlocksFromLimak(n-cubed);
        return 0;
    }
    
    public static ArrayList<Long> genCubes()
    {
        ArrayList<Long> ret = new ArrayList<Long>();
        long compare = (long)Math.pow(10,15.0);
        for(long i = 1; i < (long)Math.pow(compare,0.5); i++)
        {
            long temp = i*i*i;
            //out.println(temp);
            if(temp<compare)
                ret.add(temp);
        }
        return ret;
    }
}
