import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class COINS
{
    public static HashMap<Long,Long> vals;
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        //String output = ""; //Write all output to this string

        //Code here
        //vals.put(0l,0l);
        vals = new HashMap<Long,Long>();
        String line;
        while((line = f.readLine())!=null)
        {
            writer.println(getValueOfCoin(Long.parseLong(line)));
        }
        
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static long getValueOfCoin(long v)
    {
        if(v==0)
            return 0;
        long val1;
        try{
            val1 = vals.get(v);
            return val1;
        }
        catch(Exception e)
        {
            val1 = getValueOfCoin(v/2) + getValueOfCoin(v/3) + getValueOfCoin(v/4);
        }
        long val2 = v;
        long result = Math.max(val1, val2);
        vals.put(v, result);
        return result;
    }
}
