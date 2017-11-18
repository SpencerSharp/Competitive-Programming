import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class D
{
    static HashMap<Integer,HashSet<HashMap<Integer,HashMap<Integer,Integer>>>> g = new HashMap<Integer,HashSet<HashMap<Integer,HashMap<Integer,Integer>>>>();
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        //String line = f.readLine();
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        int b = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[n];
        
        st = new StringTokenizer(f.readLine());
        
        int index = 0;
        
        for(int i = 0; i < n; i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
            if(nums[i] == b)
                index = i;
        }
        
        int numMoreThan = 0;
        int numLessThan = 0;
        
        int total = 0;
        
        for(int c = 1; c <= n; c+=2)
        {
            for(int s = 0; s < c; s++)
            {
                
                int start = index - s;
                int lastIndex = start + c - 1;
                if(start >= 0 && lastIndex < n)
                {
                    out.println(g);
                    boolean isGood = getIsGood(start, c, nums, index, b);
                    if(isGood)
                        total++;
                }
            }
        }
        output = ""+total;
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static boolean getIsGood(int start, int len, int[] ray, int mid, int b)
    {
        out.println("START: "+ start + "LEN: " + len);
        HashMap<Integer,Integer> subRes = new HashMap<Integer,Integer>();
        if(len == 1)
        {
            HashMap<Integer,Integer> sub = new HashMap<Integer,Integer>();
            sub.put(0,0);
            sub.put(1,0);
            HashMap<Integer,HashMap<Integer,Integer>> cont = new HashMap<Integer,HashMap<Integer,Integer>>();
            
            cont.put(start,sub);
            //out.println("CONT:" + cont);
            g.put(len,cont);
            return true;
        }
        else if(len == 3)
        {
            if(start==mid-2)
            {
                subRes = g.get(len-2).get(start+2);
                modify(subRes,start,start+1,ray,b);
            }
            else if(start == mid-1)
            {
                subRes = g.get(len-2).get(start+1);
                modify(subRes,start,start+2,ray,b);
            }
            else
            {
                subRes = g.get(len-2).get(start);
                modify(subRes,start+1,start+2,ray,b);
            }
        }
        else
        {
            if(mid-start > (len/2))
            {
                subRes = g.get(len-2).get(start+2);
                modify(subRes,start,start+1,ray,b);
            }
            else
            {

                subRes = g.get(len-2).get(start);
                modify(subRes,start+len-2,start+len-3,ray,b);
            }
        }
        HashMap<Integer,HashMap<Integer,Integer>> result = new HashMap<Integer,HashMap<Integer,Integer>>();
        result.put(start,subRes);
        g.put(len,result);
        return subRes.get(0) == subRes.get(1);
    }
    
    public static void modify(HashMap<Integer,Integer> things, int num1, int num2, int[] ray, int b)
    {
        //things = new HashMap<Integer,Integer>();
        int res1 = ray[num1];
        if(res1 < b)
        {
            if(things.get(0)!=null)
            {
                things.put(0,things.get(0)+1);
            }
            else
            {
                things.put(0,1);
            }
        }
        else
        {
            if(things.get(1)!=null)
            {
                things.put(1,things.get(1)+1);
            }
            else
            {
                things.put(1,1);
            }
        }
        
        int res2 = ray[num2];
        if(res2 < b)
        {
            if(things.get(0)!=null)
            {
                things.put(0,things.get(0)+1);
            }
            else
            {
                things.put(0,1);
            }
        }
        else
        {
            if(things.get(1)!=null)
            {
                things.put(1,things.get(1)+1);
            }
            else
            {
                things.put(1,1);
            }
        }
    }
}