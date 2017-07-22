import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class TextJustification
{
    static HashMap<Integer,String> words = new HashMap<Integer,String>();
    static HashMap<String,Long> dists = new HashMap<String,Long>();
    public static long lineLength;
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        lineLength = Long.parseLong(f.readLine());
        String input = f.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int index = 0;
        while(st.hasMoreTokens())
        {
            words.put(index++,st.nextToken());
        }
        //for(int i = 0; i < index;i++)
        //    out.println(words.get(i));
        //index is # of words
        long min = -1;
        for(int j1 = 1; j1 < index; j1++)
            for(int i2 = j1; i2 < index; i2++)
            {
                //out.println("START 0,"+j1 + "-" + i2 + ","+index);
                long temp = getDistFrom(0,j1,i2,index);
                if(temp!=-1)
                    if(min==-1 || temp < min)
                        min = temp;
            }
        out.println(min);
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static long getDistFrom(int i1, int j1, int i2, int j2)
    {
        if(j1==i2)
        {
            String lookup = "DONE "+i1+","+j1+"-"+i2+","+j2;
            //out.println(lookup);
            long temp1 = getBadness(i1,j1);
            long temp2 = getBadness(i2,j2);
            if(temp1==-1||temp2==-1)
                return -1;
            //out.println(temp1+temp2);
            return temp1+temp2;
        }
        else
        {
            String lookup = i1+","+j1+"-"+i2+","+j2;
            if(dists.containsKey(lookup))
                return dists.get(lookup);
            
            long min = -1;
            for(int i = j1; i < i2; i++)
            {
                //out.println(i1+","+j1+"-"+i+","+i2);
                long temp = getDistFrom(i1,j1,i,i2);
                if(temp != -1 && (min == -1 || temp < min))
                    min = temp;
            }
            long tempB = getBadness(i2,j2);
            if(tempB == -1 || min == -1)
            {
                dists.put(lookup, -1l);
                return -1;
            }
            dists.put(lookup,min+tempB);
            return min + tempB;
        }
    }
    
    public static long getBadness(int i, int j)
    {
        long total = 0;
        for(int ind = i; ind < j; ind++)
        {
            //out.println(words.get(ind));
            total += words.get(ind).length() + 1;
        }
        total--;
        if(total > lineLength)
            return -1;
        else
            return (lineLength-total)*(lineLength-total)*(lineLength-total);
    }
}