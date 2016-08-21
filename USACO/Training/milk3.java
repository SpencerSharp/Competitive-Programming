/*
ID: spencer16
LANG: JAVA
PROG: milk3
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class milk3
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int totalMilk = c;
        
        ArrayList<Integer> allPossibleAmountsInC = pourMilks(a,b,c);
        
        TreeSet<Integer> condensedAllPossibleAmounts = new TreeSet<Integer>();
        for(int n : allPossibleAmountsInC)
            condensedAllPossibleAmounts.add(n);
        for(int n : condensedAllPossibleAmounts)
            output += n + " "; 
        output = output.substring(0,output.length()-1);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean notDone(ArrayList<int[]> prevStates, int curA, int curB, int curC, String pour)
    {
        for(int[] ray : prevStates)
            if(ray[0]==curA && ray[1]==curB&&ray[2]==curC&&ray[3]==getPourInt(pour))
                return true;
        return false;
    }
    
    public static ArrayList<Integer> pourMilks(int a, int b, int c)
    {
        ArrayList<Integer> results = new ArrayList<Integer>();
        results.addAll(pourMilk(a,b,c,0,0,c,new ArrayList<int[]>(),"ca"));
        results.addAll(pourMilk(a,b,c,0,0,c,new ArrayList<int[]>(),"cb"));
        return results;
    }
    
    public static String getPourName(int i)
    {
        if(i==0)
            return "ab";
        else if(i==1)
            return "ac";
        else if(i==2)
            return "ba";
        else if(i==3)
            return "bc";
        else if(i==4)
            return "ca";
        else
            return "cb";
    }
    
    public static int getPourInt(String s)
    {
        if(s.equals("ab"))
            return 0;
        else if(s.equals("ac"))
            return 1;
        else if(s.equals("ba"))
            return 2;
        else if(s.equals("bc"))
            return 3;
        else if(s.equals("ca"))
            return 4;
        else
            return 5;
    }
    
    public static ArrayList<int[]> add(ArrayList<int[]> prevStates, int curA, int curB, int curC, String pour)
    {
        int[] ray = new int[4];
        ray[0] = curA;
        ray[1] = curB;
        ray[2] = curC;
        ray[3] = getPourInt(pour);
        prevStates.add(ray);
        return prevStates;
    }
    
    public static ArrayList<Integer> pourMilk(int a, int b, int c, int curA, int curB, int curC, ArrayList<int[]> prevStates, String pour)
    {
        //out.println(pour);
        if(!notDone(prevStates,curA,curB,curC,pour))
        {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            if(curA==0)
                ret.add(curC);
            prevStates = add(prevStates,curA,curB,curC,pour);
            if(pour.equals("ab"))
            {
                if(curA > (b-curB)) //If more milk in A than room in b
                {
                    int newA = curA-(b-curB);
                    int newB = b;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,newA,newB,curC,prevStates,getPourName(i)));
                }
                else
                {
                    int newA = 0;
                    int newB = curB + curA;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,newA,newB,curC,prevStates,getPourName(i)));
                }
            }
            else if(pour.equals("ac"))
            {
                if(curA > (c-curC))
                {
                    int newA = curA-(c-curC);
                    int newC = c;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,newA,curB,newC,prevStates,getPourName(i)));
                }
                else
                {
                    int newA = 0;
                    int newC = curC + curA;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,newA,curB,newC,prevStates,getPourName(i)));
                }
            }
            else if(pour.equals("ba"))
            {
                if(curB > (a - curA))
                {
                    int newB = curB - (a-curA);
                    int newA = a;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,newA,newB,curC,prevStates,getPourName(i)));
                }
                else
                {
                    int newB = 0;
                    int newA = curA + curB;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,newA,newB,curC,prevStates,getPourName(i)));
                }
            }
            else if(pour.equals("bc"))
            {
                if(curB > (c - curC))
                {
                    int newB = curB - (c-curC);
                    int newC = c;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,curA,newB,newC,prevStates,getPourName(i)));
                }
                else
                {
                    int newB = 0;
                    int newC = curC + curB;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,curA,newB,newC,prevStates,getPourName(i)));
                }
            }
            else if(pour.equals("ca"))
            {
                if(curC > (a - curA))
                {
                    int newC = curC - (a-curA);
                    int newA = a;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,newA,curB,newC,prevStates,getPourName(i)));
                }
                else
                {
                    int newC = 0;
                    int newA = curA + curC;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,newA,curB,newC,prevStates,getPourName(i)));
                }
            }
            else if(pour.equals("cb"))
            {
                if(curC > (b - curB))
                {
                    int newC = curC - (b-curB);
                    int newB = b;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,curA,newB,newC,prevStates,getPourName(i)));
                }
                else
                {
                    int newC = 0;
                    int newB = curB + curC;
                    for(int i = 0; i < 6; i++)
                        ret.addAll(pourMilk(a,b,c,curA,newB,newC,prevStates,getPourName(i)));
                }
            }
            return ret;
        }
        else
        {
            //out.println("duped");
            return new ArrayList<Integer>();
        }
    }
}