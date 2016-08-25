/*
ID: spencer16
LANG: JAVA
PROG: runround
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class runround
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        //out.println(removeZeroes(90));
        long num = Long.parseLong(f.readLine());
        long index = 1;
        long newNum = num;
        long curNum = num+index;
        while(newNum==num)
        {
            //out.println(curNum);
            if(isRunaround(curNum,0,new ArrayList<Integer>()))
                newNum = curNum;
            curNum = getNextPosRunaround(curNum);
            //out.println(temp);
        }

        //out.println(""+isRunaround(142,0,new ArrayList<Integer>()));

        //Code here

        //out.println(newNum);
        
        writer.println(newNum);
        writer.close();
        System.exit(0);
        
    }

    public static boolean isRunaround(long n, int curInd, ArrayList<Integer> prevNums)
    {
        String num = ""+n;
        int curNum = Integer.parseInt(""+num.charAt(curInd));
        if(curNum==0)
            return false;
        //out.println(num.length());
        prevNums.add(curNum);
        //out.println(prevNums);
        
        
        
        int newInd = (curInd+curNum)%num.length();
        if(num.length()==prevNums.size() && newInd==0)
        {
            return true;
        }
        //out.println((curInd+curNum) + "%" + num.length());
        //out.println(newInd);
        int newNum = Integer.parseInt(""+num.charAt(newInd));
        //out.println(newNum);
        if(contains(prevNums,newNum))
        {
            return false;
        }
        else
        {
            return isRunaround(n,newInd,prevNums);
        }
    }

    public static boolean contains(ArrayList<Integer> numList, int n)
    {
        for(int num : numList)
            if(num==n)
                return true;
        return false;
    }
    
    public static long getNextPosRunaround(long n)
    {
        String num = n+"";
        long lastDig = Long.parseLong(""+num.charAt(num.length()-1));
        if(lastDig==9)
        {
            return removeZeroes(n+2);
        }
        else
            return removeZeroes(n+1);
    }
    public static long removeZeroes(long n)
    {
        String num = ""+n;
        for(int i = 1; i < num.length() && i <= 3; i++)
        {
            if(num.charAt(i)=='0')
                num = num.substring(0,i)+"1"+num.substring(i+1);
        }
        return Long.parseLong(num);
    }
}