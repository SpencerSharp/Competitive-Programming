import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class EIGHTS
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        String output = ""; //Write all output to this string

        //Code here
        HashMap<Long,Long> map = new HashMap<Long,Long>();
        HashMap<Long,Long> map2 = new HashMap<Long,Long>();
        long index = 1;
        long max = (long)Math.pow(2, 63);
        long prev = 192;
        max = (long)Math.cbrt((double)max);
        /*for(long n = 192; n < max; n++)
        {
            long result = (long)Math.pow(n, 3);
            String res = ""+result;
            if(res.length()>=3)
            {
                int len = res.length();
                if(res.charAt(len-1)=='8')
                    if(res.charAt(len-2)=='8')
                        if(res.charAt(len-3)=='8')
                        {
                            //out.println(n-prev);
                            map.put(index++,n);
                            prev = n;
                        }
            }
            //out.println("loop");
        }*/
        long diff = 250;
        index = 1;
        /*for(long n = 192; n <= max; n+=diff)
        {
            map2.put(index++, n);
        }*/
        long numCases = Long.parseLong(f.readLine());
        for(int i = 0; i < numCases; i++)
        {
            long wantedInd = Long.parseLong(f.readLine());
            writer.println(192 + ((wantedInd-1)*250));// + " " + map.get(wantedInd));
            //writer.println(map2.get(wantedInd));// + " " + map2.get(wantedInd));
        }
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
