import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF492B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        //out.println(line.length()-2);
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        ArrayList<Long> lants = new ArrayList<Long>();
        line = f.readLine();
        st = new StringTokenizer(line);
        for(int i = 0; i < n; i++)
        {
            lants.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(lants);
        
        double maxDist = lants.get(0);
        double posMaxDist = l-lants.get(lants.size()-1);
        if(posMaxDist>maxDist)
            maxDist = posMaxDist;
        for(int i = 0; i < lants.size()-1; i++)
        {
            double dist = lants.get(i+1)-lants.get(i);
            dist /= 2;
            if(dist > maxDist)
                maxDist = dist;
        }
        output = String.format("%.10f", maxDist);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
