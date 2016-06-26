import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class OnlineExam
{
    static String realKey;
    public static void main(String[] args) throws IOException
    {
        for(int i = 0; i < 100; i++)
        {
            realKey = genRandom(5000);
            exec();
        }
    }
    
    public static void exec() throws IOException
    {
        int n = 5000;
        int x = 100;
        int k = 2000;
        String initAttempt1 = genRandom(n);
        int testInit1 = test(initAttempt1);
        String theString;
        int theResult;
        theString = initAttempt1;
        theResult = testInit1;
        String key = "";
        for(int i = 0; i < x-2; i++) //Loops through each attempt
        {
            if(i < (x-4))
            {
                //out.println(i + " " + 51*(i+1));
                String test = flip(theString,51*i,51*(i+1));
                int testResult = test(test);
                if(testResult > theResult)
                    key += "1";
                else
                    key += "0";
            }
            else
            {
                int start = 51 * 96 + (52 * (i-96));
                int end = 51 * 96 + (52 * (i-95));
                //out.println(i + " " + end);
                String test = flip(theString,start,end);
                int testResult = test(test);
                if(testResult > theResult)
                    key += "1";
                else
                    key += "0";
            }
        }
        String finalResult = "";
        for(int i = 0; i < x-2; i++)
        {
            int isBetterToFlip = Integer.parseInt(""+key.charAt(0));
            if(i < (x-4))
            {
                if(isBetterToFlip==0)
                {
                    finalResult += theString.substring(51*i,51*(i+1));
                }
                else
                {
                    finalResult += flip(theString,51*i,51*(i+1));
                }
            }
            else
            {
                int start = 51 * 96 + (52 * (i-96));
                int end = 51 * 96 + (52 * (i-95));
                if(isBetterToFlip==0)
                {
                    finalResult += theString.substring(start,end);
                }
                else
                {
                    finalResult += flip(theString,start,end);
                }
            }
        }
        //submit(finalResult);
        out.println(test(finalResult));
    }

    public static String flip(String theString, int start, int end)
    {
        String ret = theString.substring(0,start);
        for(int i = start; i < end; i++)
        {
            if(theString.charAt(i)=='0')
            {
                ret += "1";
            }
            else
            {
                ret += "0";
            }
        }
        ret += theString.substring(end);
        return ret;
    }

    /*
    public static int test(String output) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        out.println(output);
        out.flush();
        String result = f.readLine();
        int number = Integer.parseInt(result);
        return number;
    }
    */
    
    public static int test(String output)
    {
        int total = 0;
        int index = 0;
        while(total < 2000)
        {
            if(output.charAt(index)!=realKey.charAt(index))
                total++;
            index++;
        }
        return index;
    }

    public static void submit(String output) throws IOException
    {
        //out.println(output);
        //out.flush();
    }

    public static String genRandom(int len)
    {
        String ret = "";
        for(int i = 0; i < len; i++)
        {
            ret += (int)(Math.random() * 2);
        }
        return ret;
    }
}