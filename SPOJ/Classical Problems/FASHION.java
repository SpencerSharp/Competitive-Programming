/*
ID: spencer16
LANG: JAVA
PROG: FASHION
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class FASHION
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        //String output = ""; //Write all output to this string

        //Code here
        int numCases = Integer.parseInt(f.readLine());
        for(int x = 0; x < numCases; x++)
        {
            int numModels = Integer.parseInt(f.readLine());
            ArrayList<Long> maleModels = new ArrayList<Long>();
            ArrayList<Long> femaleModels = new ArrayList<Long>();
            String maleLine = f.readLine();
            StringTokenizer st = new StringTokenizer(maleLine);
            for(int i = 0; i < numModels; i++)
            {
                maleModels.add(Long.parseLong(st.nextToken()));
            }
            String femaleLine = f.readLine();
            st = new StringTokenizer(femaleLine);
            for(int i = 0; i < numModels; i++)
            {
                femaleModels.add(Long.parseLong(st.nextToken()));
            }
            Collections.sort(maleModels);
            Collections.sort(femaleModels);
            int index = maleModels.size()-1;
            long sum = 0;
            while(index>=0)
            {
                long male = maleModels.remove(index);
                long fem = femaleModels.remove(index);
                sum += (male * fem);
                index = maleModels.size()-1;
            }
            writer.println(sum);
        }
        
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
