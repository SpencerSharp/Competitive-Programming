/*
ID: spencer16
LANG: JAVA
PROG: subset
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class subset
{
    static long timeInLoop = 0;
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));

        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        //long start = System.nanoTime();
        int num = (n*(n+1));
        /*
        for(int i = 3; i<=27; i++)
        {
            int num = ((i*(1+i))/2)/2;
            out.println(getNumValidSetups(i,0,0,new HashSet<Integer>(),num));
        }*/
        //out.println(getNumValidSetups(input,0,0,new HashSet<Integer>(),num));
        if(num%4!=0)
            writer.println("0");
        else if(num==1)
            writer.println("1");
        else
        {
            num/=4;
            long[][] ray = new long[40][(40*40)/2];
            for(int i = 0; i <= n; i++)
                ray[i][0] = 1;
            for(int i = 1; i < ray[0].length; i++)
                ray[0][i] = 0;
            for (int i=1;i<=n;i++)
                for (int j=1;j<=num;j++)
                    if (j>=i)
                        ray[i][j]=ray[i-1][j]+ray[i-1][j-i];
                    else
                        ray[i][j]=ray[i-1][j];
            writer.println(ray[n][n*(n+1)/4]/2);
        }
        //long end = System.nanoTime();
        //long time = end - start;
        //out.println(((double)timeInLoop)/((double)time));
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }

    public static int getNumValidSetups(int n, int min, int curTotal, HashSet<Integer> nums, int calced)
    {
        //out.println(curTotal);
        //long start = System.nanoTime();
        int result = isValid(calced,curTotal);
        if(result==0)
        {
            //long end = System.nanoTime();
            //timeInLoop += (end-start);
            int total = 0;
            for(int i = min+1; i < n; i++)
            {
                if(!nums.contains(i))
                {
                    //long start = System.nanoTime();
                    /*HashSet<Integer> nums2 = new HashSet<Integer>();
                    for(int num : nums)
                    {
                        nums2.add(num);
                    }
                    long end = System.nanoTime();
                    timeInLoop += (end-start);*/
                    //long start = System.nanoTime();
                    nums.add(i);
                    //long end = System.nanoTime();
                    //timeInLoop += (end-start);
                    total += getNumValidSetups(n,i,curTotal+i,nums,calced);
                    //start = System.nanoTime();
                    nums.remove(i);
                    //end = System.nanoTime();
                    //timeInLoop += (end-start);
                }
                //if(curTotal==0)
                //    out.println(total);
            }
            return total;
        }
        else if(result==2)
        {
            return 0;
        }
        else
            return 1;
    }
    
    public static int isValid(int calced, int curTotal)
    {
        if(calced>curTotal)
            return 0;
        else if(calced<curTotal)
            return 2;
        else
            return 1;
    }

    /*
    public static boolean isValid(int n, int curTotal)
    {
        return (((n*(1+n))/2)/2)==curTotal;
    }

    public static boolean shouldStopBranch(int n, int curTotal)
    {
        return (((n*(1+n))/2)/2)<curTotal;
    }
    */
}
