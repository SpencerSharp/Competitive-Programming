/*
ID: spencer16
LANG: JAVA
PROG: zerosum
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class zerosum
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));

        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
            nums.add(i);
        ArrayList<Integer> ops = new ArrayList<Integer>();
        ArrayList<String> results = getZeroSums(nums,ops);
        for(String s : results)
            writer.println(display(nums,s));
        //ArrayList<Integer> testOps = new ArrayList<Integer>(Arrays.asList(1,2,1,2,2,1));
        //out.println(compute(nums,testOps));
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
        
    }
    
    public static ArrayList<String> getZeroSums(ArrayList<Integer> nums, ArrayList<Integer> ops)
    {
        //out.println(nums);
        //out.println(ops);
        if(ops.size()==nums.size()-1)
        {
            //Check if zero sum, return concat(ops) in an arraylist if it is
            ArrayList<String> ret = new ArrayList<String>();
            if(compute(nums,ops))
            {
                //out.println(ops);
                ret.add(concat(ops));
            }
            return ret;
        }
        else
        {
            ArrayList<String> ret = new ArrayList<String>();
            for(int i = 0; i < 3; i++)
            {
                //ArrayList<Integer> copyOps = new ArrayList<Integer>();
                //for(int n = 0; n < ops.size(); n++)
                //    copyOps.add(ops.get(n));
                //copyOps.add(i);
                ops.add(i);
                ret.addAll(getZeroSums(nums,ops));
                ops.remove(ops.size()-1);
            }
            return ret;
        }
    }
    
    public static String concat(ArrayList<Integer> ops)
    {
        String ret = "";
        for(int s : ops)
            ret += s;
        return ret;
    }
    
    public static boolean compute(ArrayList<Integer> copyNums, ArrayList<Integer> copyOps)
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < copyNums.size(); i++)
            nums.add(copyNums.get(i));
        ArrayList<Integer> ops = new ArrayList<Integer>();
        for(int i = 0; i < copyOps.size(); i++)
            ops.add(copyOps.get(i));
        //out.println(nums);
        while(ops.contains(0))
        {
            //out.println(nums);
            //out.println(ops);
            int zeroInd = 0;
            for(int i = 0; i < ops.size(); i++)
                if(ops.get(i)==0)
                {
                    zeroInd = i;
                    break;
                }
            int temp = nums.remove(zeroInd+1);
            int cur = nums.get(zeroInd);
            int newInt = Integer.parseInt((""+cur)+(""+temp));
            nums.set(zeroInd,newInt);
            //out.println(nums);
            ops.remove(zeroInd);
        }
        while(ops.size()>0)
        {
            if(ops.get(0)==1) //add
            {
                int temp = nums.remove(1);
                int cur = nums.get(0);
                int newInt = temp+cur;
                nums.set(0,newInt);
                //out.println(nums);
            }
            else //subtract
            {
                int temp = nums.remove(1);
                int cur = nums.get(0);
                int newInt = cur-temp;
                nums.set(0,newInt);
                //out.println(nums);
            }
            ops.remove(0);
        }
        
        return nums.get(0)==0;
    }
    
    public static String display(ArrayList<Integer> nums, String ops)
    {
        String disp = "";
        for(int i = 0; i < nums.size() + ops.length(); i++)
        {
            if(i%2==0)
            {
                disp += nums.get(i/2);
            }
            else
            {
                String op = " ";
                int opVal = Integer.parseInt(""+ops.charAt(i/2));
                if(opVal==1)
                    op="+";
                else if(opVal==2)
                    op="-";
                disp += op;
            }
        }
        return disp;
    }
}
