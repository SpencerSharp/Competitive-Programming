import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Voley
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
        int rotations = Integer.parseInt(f.readLine());
        
        String setter = f.readLine();
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        String[] startingRay = new String[6];
        
        for(int i = 0; i < 6; i++)
        {
            startingRay[i] = st.nextToken();
        }
        
        st = new StringTokenizer(f.readLine());
        
        int numBench = Integer.parseInt(st.nextToken());
        String[] benchRay = new String[numBench];
        
        for(int i = 0; i < numBench; i++)
        {
            benchRay[i] = st.nextToken();
        }
        
        String[] teamRay = new String[6+numBench];
        for(int i = 0; i < 6; i++)
        {
            teamRay[i] = startingRay[i];
        }
        for(int i = 0; i < numBench; i++)
        {
            teamRay[i+6] = benchRay[i];
        }
        
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static String[] rotateNTimes(String[] ray, String setter, int times)
    {
        if(times==0)
            return ray;
        else
        {
            
        }
    }
    
    public static String[] rotate(String[] ray, String setter)
    {
        if(ray[1].equals(setter))
        {
            String temp = ray[0];
            
            ray[0] = setter;
            
            //0->5
            ray[5] = setter;
        }
        else
        {
            
        }
        //1->bench
        //5->4
        ray[4] = ray[5];
        //4->3
        ray[3] = ray[4];
        //3->2
        ray[2] = ray[3];
        //2->1
        ray[1] = ray[2];
        //bench->0
        ray[ray.length-1] = 
        ray[5] = ray[1];
    }
}