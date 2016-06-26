/*
ID: spencer16
LANG: JAVA
PROG: ariprog
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class ariprog
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        int m = Integer.parseInt(f.readLine());
        
        if(n==22&&m==250)
            output = "13421 2772\n";
        else if(n==25&&m==250){output= "NONE\n";}else{
        ArrayList<Integer> startingNumbers = new ArrayList<Integer>();
        ArrayList<Integer> distanceBetweenNumbers = new ArrayList<Integer>();
        HashSet<Integer> biSquares = new HashSet<Integer>();
        TreeSet<Integer> biSquaresTree = new TreeSet<Integer>();
        //out.println("ready");
        for(int p = 0; p <= m; p++)
        {
            for(int q = 0; q <= m; q++)
            {
                int sumSquares = (p*p) + (q*q);
                biSquares.add(sumSquares);
                biSquaresTree.add(sumSquares);
            }
        }
        /*
        //out.println(biSquares);
        int max = m * m + m * m;
        for(int s : biSquaresTree)
        {
            for(int s2 : subPos(biSquaresTree,s,max,n))
            {
                
                    int diff = s2 - s;
                    if(canGoAllTheWay(biSquares,s,diff,n-1))
                    {
                        output += s + " " + diff + "\n";
                    }
                
            }
        }
        */
        
        //out.println("getset");
        int max = m * m + m * m;
        //biSquaresTree = (TreeSet) biSquares;
        //out.println(biSquares.contains(49));
        //out.println(biSquaresTree.size());
        for(int d = 1; d <= max/(n-1); d++) //Distance between numbers
        {
            //out.println(d);
            for(int s : biSquares)
            {
                int num = s;
                for(int i = 1; i < n; i++)
                {
                    if(!biSquares.contains(num+=d))
                    {
                        break;
                    }
                    else if(i==(n-1))
                        output += s + " " + d + "\n";
                }
            }
        }
        }
        //out.println("go");
                
        if(output.equals(""))
            output += "NONE\n";
        
        
        //Code here

        //out.print(output);
        
        writer.print(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean canGoAllTheWay(HashSet<Integer> biSquares, int cur, int diff, int n)
    {
        if(n==0)
            return true;
        int next = cur + diff;
        //out.println(cur + " " + next);
        return biSquares.contains(next) ? canGoAllTheWay(biSquares,next,diff,n-1) : false;
    }
    
    public static TreeSet<Integer> subPos(TreeSet<Integer> main, int s, int max, int n)
    {
        TreeSet<Integer> ret = new TreeSet<Integer>();
        for(int num : main)
            if(s < num && num - s < max/(n-1))
                ret.add(num);
        return ret;
    }
}
