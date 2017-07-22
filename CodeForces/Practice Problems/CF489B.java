import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF489B
{
    static HashMap<ArrayList<Integer>,Long> results = new HashMap<ArrayList<Integer>,Long>();
    static int trueMax;
    
    //int[] details:
    //0-99 boys dancing skills
    //100-199 boys availability (0 avail, 1 not avail)
    //200-299 girls dancing skills
    //300-399 girls availability (0 avail, 1 not avail)

    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        ArrayList<Integer> ray = new ArrayList<Integer>();
        int numBoys = Integer.parseInt(f.readLine());
        
        int[] boyRay = new int[numBoys];
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < numBoys; i++)
            boyRay[i] = Integer.parseInt(st.nextToken());
        
        int numGirls = Integer.parseInt(f.readLine());
        
        int[] girlRay = new int[numGirls];
        
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < numGirls; i++)
            girlRay[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(boyRay);
        Arrays.sort(girlRay);
        
        for(int i = 0; i < 100; i++)
        {
            if(i >= boyRay.length)
                ray.add(0);
            else
                ray.add(boyRay[i]);
        }
        
        trueMax = Math.max(numBoys,numGirls);
        
        for(int i = 0; i < 100; i++)
            ray.add(0);
        
        for(int i = 0; i < numGirls; i++)
        {
            if(i >= girlRay.length)
                ray.add(0);
            else
                ray.add(girlRay[i]);
        }
        
        for(int i = 0; i < 100; i++)
            ray.add(0);
        
        output = ""+getMaxPairsOfRay(ray);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static long getMaxPairsOfRay(ArrayList<Integer> ray)
    {
        if(results.get(ray)!=null)
        {
            //out.println("swag");
            return results.get(ray);
        }
        long max = 0;
        for(int i = 0; i < 100; i++)
        {
            if(ray.get(i)!=0 && ray.get(100+i)!=1)
            {
                ray.set(100+i,1);
                for(int j = 0; j < 100; j++)
                {
                    if(ray.get(200+j)!=0 && ray.get(300+j)!=1)
                    {
                        if(Math.abs(ray.get(i)-ray.get(200+j))<=1)
                        {
                            ray.set(300+j,1);
                            max = Math.max(max,getMaxPairsOfRay(ray) + 1);
                            return max;
                            //ray.set(300+j,0);
                        }
                    }
                    
                }
                ray.set(100+i,0);
            }
        }
        results.put(ray, max);
        return max;
    }
}