import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

//Later: http://codeforces.com/contest/676/problem/B
public class GlassesPyramid
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int pyrHeight = Integer.parseInt(st.nextToken());
        int vol = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Double>> streamStarts = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> level1  =new ArrayList<Double>();
        level1.add(0.0);
        streamStarts.add(level1);
        output+=getGlassesFullAt(vol,streamStarts,1,pyrHeight);
        
        
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static int volOfStream(int curLevel, int posInLevel)
    {
        
    }
    
    public static double timeWhenFull(ArrayList<Double> streamStarts, int curLevel, int posInLevel)
    {
        if(streamStarts.size()==1)
        {
            return streamStarts.get(0)/volOfStream(curLevel,posInLevel);
        }
        else if(streamStarts.size()==2)
        {
            double lower = Math.min(streamStarts.get(0),streamStarts.get(1));
            double higher = Math.max(streamStarts.get(0),streamStarts.get(1));
            if(higher-lower>=volOfStream(curLevel,posInLevel))
            {
                return lower+Math.pow(2,curLevel-1);
            }
            else
            {
                double diff = higher-lower;
                double oneMinus = Math.pow(2,curLevel-1) - diff;
                oneMinus/=2;
                return lower + diff + oneMinus;
            }
        }
        return -1;
    }
    
    public static ArrayList<ArrayList<Double>> copy(ArrayList<ArrayList<Double>> s)
    {
        ArrayList<ArrayList<Double>> s2 = new ArrayList<ArrayList<Double>>();
        for(int i = 0; i < s.size(); i++)
        {
            ArrayList<Double> t = new ArrayList<Double>();
            s2.add(t);
            for(int j = 0; j < s.get(i).size(); j++)
                s2.get(i).add(s.get(i).get(j));
        }
        //out.println(s);
        //out.println(s2);
        return s2;
    }
    public static ArrayList<ArrayList<Double>> add(int i, double timeToFill, ArrayList<ArrayList<Double>> streamStarts)
    {
        //out.println(streamStarts);
        ArrayList<ArrayList<Double>> s2 = copy(streamStarts);
        if(s2.size()<=i)
        {
            ArrayList<Double> ray = new ArrayList<Double>();
            ray.add(timeToFill);
            s2.add(ray);
        }
        else
        {
            s2.get(i).add(timeToFill);
        }
        return s2;
    }

    public static int getGlassesFullAt(double time, ArrayList<ArrayList<Double>> streamStarts, int curLevel, int height)
    {
        //out.println("call");
        if(curLevel>height)
            return 0;
        out.println(streamStarts);
        int total = 0;
        ArrayList<ArrayList<Double>> newStreamStarts = new ArrayList<ArrayList<Double>>();
        for(int i = 0; i < curLevel; i++)
        {
            double timeWhenFull = timeWhenFull(streamStarts.get(i),curLevel,i);
            out.println(curLevel + " " + timeWhenFull);
            for(int j = 0; j < 2; j++)
            {
                newStreamStarts = add(i+j,timeWhenFull,newStreamStarts);
            }
            if(timeWhenFull<=time)
                total++;
        }
        
        total += getGlassesFullAt(time, newStreamStarts, curLevel+1, height);
        return total;
    }
}
