/*
ID: spencer16
LANG: JAVA
PROG: haybales
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class haybales
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        */
        String output = ""; //Write all output to this string

        //Code here
        HashMap<Integer,Integer> haybales = new HashMap<Integer,Integer>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        String line;
        StringTokenizer st;
        line = f.readLine();
        st = new StringTokenizer(line);
        int numBales = Integer.parseInt(st.nextToken());
        int numQueries = Integer.parseInt(st.nextToken());
        line = f.readLine();
        st = new StringTokenizer(line);
        for(int i = 0; i < numBales; i++)
        {
            int bale = Integer.parseInt(st.nextToken());
            int n = haybales.put(bale, 1);
            haybales.put(bale, n+1);
            if(haybales.containsKey(bale))
            {
                haybales.put(bale, haybales.get(bale)+1);
            }
            else
            {
                indexes.add(bale);
                haybales.put(bale,1);
            }
        }
        Collections.sort(indexes);
        out.println(haybales);
        for(int i = 0; i < numQueries; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int index;
            if(indexes.get((Integer)start)!=null)
                index = indexes.get(start);
            else
                index = Collections.binarySearch(indexes, start);
            int total = 0;
            int val;
            if(index >= 0)
                val = start;
            else
            {
                index *= -1;
                index -= 1;
                if(index < indexes.size())
                    val = indexes.get(index);
                else
                    val = end + 1;
            }
            while(val <= end)
            {
                //out.println("index"+index);
                total += haybales.get(val);
                index++;
                if(index < indexes.size())
                    val = indexes.get(index);
                else
                    val = end +1;
            }
            out.println(total);
        }
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        //writer.close();
        //System.exit(0);
        
    }
}
