import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF474B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numPiles = Integer.parseInt(f.readLine());
        
        int[] pileStarts = new int[numPiles];
        
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        
        int total = 1;
        
        for(int i = 0; i < numPiles; i++)
        {
            int pileSize = Integer.parseInt(st.nextToken());
            pileStarts[i] = total;
            total += pileSize;
        }
        
        //out.println(disp(pileStarts));
        
        int numJuicies = Integer.parseInt(f.readLine());
        
        line = f.readLine();
        st = new StringTokenizer(line);
        
        int start = 0;
        int end = numPiles-1;
        int mid = (start+end)/2;
        
        for(int i = 0; i < numJuicies; i++)
        {
            int juicyWormLabel = Integer.parseInt(st.nextToken());
            
            //if(juicyWormLabel>pileStarts[mid]&&juicyWormLabel<pileStarts[mid+1])
            //    out.println(mid+1);
            //else
            writer.println(getIndexOfBinarySearchResult(pileStarts,juicyWormLabel,0,numPiles-1)+1);
        }
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getIndexOfBinarySearchResult(int[] ray, int n, int start, int end)
    {
        
        if(end-start==1)
        {
            if(n < ray[end])
                return start;
            return end;
        }
        else if(end==start)
            return start;
        int mid = (end+start)/2;
        if(n > ray[mid] && mid < ray.length-1 && n < ray[mid+1])
            return mid;
        if(n < ray[mid])
        {
            return getIndexOfBinarySearchResult(ray,n,start,mid-1);
        }
        else if(n > ray[mid])
        {
            return getIndexOfBinarySearchResult(ray,n,mid+1,end);
        }
        else
            return mid;
    }
    
    public static String disp(int[] ray)
    {
        String result = "";
        for(int n : ray)
            result += n + " ";
        return result;
    }
}