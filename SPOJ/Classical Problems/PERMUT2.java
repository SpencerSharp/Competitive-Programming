import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class PERMUT2
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        int size = Integer.parseInt(line);
        while(size!=0)
        {
            int[] ray = new int[size];
            line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for(int i = 0; i < size; i++)
                ray[i] = Integer.parseInt(st.nextToken());
            
            int[] ray2 = inv(ray);
            if(isSame(ray,ray2))
                out.println("ambiguous");
            else
                out.println("not ambiguous");
            //out.println(display(ray));
            //out.println(display(inv(ray)));
            
            line = f.readLine();
            size = Integer.parseInt(line);
        }
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean isSame(int[] ray, int[] ray2)
    {
        for(int i = 0; i < ray.length; i++)
        {
            if(ray[i]!=ray2[i])
                return false;
        }
        return true;
    }
    
    public static String display(int[] ray)
    {
        String ret = "";
        for(int i = 0; i < ray.length; i++)
            ret += ray[i] + " ";
        ret = ret.substring(0,ret.length()-1);
        return ret;
    }
    
    public static int[] inv(int[] ray)
    {
        int[] ray2 = new int[ray.length];
        int cur = 1;
        for(int n : ray)
        {
            ray2[n-1] = cur++;
        }
        return ray2;
    }
}