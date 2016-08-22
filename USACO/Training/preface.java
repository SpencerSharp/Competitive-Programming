/*
ID: spencer16
LANG: JAVA
PROG: preface
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class preface
{
    public static HashMap<Integer,String> romanNums = new HashMap<Integer,String>();
    public static char[] romans = {'I','V','X','L','C','D','M'};
    public static int[] romanVals = {1,5,10,50,100,500,1000};
    public static String[] allromans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    public static int[] allromanVals = {  1,   4,  5,   9, 10,  40, 50,  90,100, 400,500, 900,1000};
    public static void main(String[] args) throws IOException
    {
        /*
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        
        String output = ""; //Write all output to this string
        

        //Code here
        HashMap<Character,Integer> hashVals = new HashMap<Character,Integer>();
        
        HashMap<Character,Integer> hashRoms = new HashMap<Character,Integer>();
        for(int i = 0; i < romans.length; i++)
        {
            hashRoms.put(romans[i],i);
            hashVals.put(romans[i],0);
        }
        int pages = Integer.parseInt(f.readLine());
        for(int i = 1; i <= pages; i++)
        {
            String roman = getRomanNum(i);
            //out.println(roman);
            for(int j = 0; j < roman.length(); j++)
            {
                char c = roman.charAt(j);
                int romanInd = hashRoms.get(c);
                hashVals.put(c,hashVals.get(c)+1);
            }
        }
        
        int[] vals = new int[7];
        for(int i = 0; i < romans.length; i++)
        {
            vals[i] = hashVals.get(romans[i]);
        }
        
        int curVal = vals[0];
        int index = 0;
        
        while(curVal!=0)
        {
            writer.println(romans[index] + " " + vals[index]);
            if(index==vals.length-1)
            {
                curVal=0;
            }
            else
            {
                index++;
                curVal = vals[index];
            }
        }
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static String getRomanNum(int n)
    {
        String ret = "";
        int newN = n;
        ret = romanNums.get(n);
        if(ret !=null)
        {
            return ret;
        }
        else
        {
            ret = "";
            //Find the roman numeral, and set ret to it
            for(int i = allromans.length-1; i >= 0; i--)
            {
                int num = 0;
                while(num < 3 && newN >= allromanVals[i])
                {
                    newN-=allromanVals[i];
                    ret += allromans[i];
                    num++;
                }
            }
            romanNums.put(n, ret);
            return ret;
        }
    }
}