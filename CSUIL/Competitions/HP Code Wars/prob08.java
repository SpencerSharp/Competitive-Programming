import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("prob08.txt"));
        String stuff = Long.toBinaryString(4);
        out.println(stuff + " " +isEvenBinaryOneCount(stuff));
        while(sc.hasNextLine())
        {
            long num1 = Long.parseLong(sc.next());
            long num2 = Long.parseLong(sc.next());
            if(num1==0&&num2==0)
                break;
            long total = 0;
            long lowerStartPoint = getLowestPowerOfTwoAbove(num1);
            long endPoint = getGreatestPowerOfTwoBelow(num2);
            out.println("REAL " + num1 + " " + num2);
            out.println("POINTS " +lowerStartPoint + " " + endPoint);
            for(long i = num1; i < lowerStartPoint; i++)
                if(isEvenBinaryOneCount(Long.toBinaryString(i)))
                    total++;
            total += (endPoint-lowerStartPoint+1)/2;
            //out.println(total);
            for(long i = endPoint+1; i <= num2; i++)
                if(isEvenBinaryOneCount(Long.toBinaryString(i)))
                    total++;
            out.println(total);
        }
        /*
        while(sc.hasNext())
        {
            String s = sc.next();
            long num = Long.parseLong(s);
            out.print(num + " ");
            out.println(getGreatestPowerOfTwoBelow(num));
        }
        for(int i = 1; i <= 10; i++)
        {
            int start = (int)Math.pow(2,i);
            int end = (int)Math.pow(2,i+1);
            //out.println(start + " " + end);
            int total = 0;
            for(int j = start; j < end; j++)
            {
                String s = Integer.toBinaryString(j);
                if(isEvenBinaryOneCount(s))
                    total++;
            }
            //out.println(((double)total)/((double)(end-start)));
        }*/
    }
    
    
    public static long getLowestPowerOfTwoAbove(long j)
    {
        String s = Long.toBinaryString(j);
        boolean allZeros = true;
        for(int i = 1; i < s.length(); i++)
            if(s.charAt(i)=='1')
                allZeros = false;
        if(allZeros)
            return j;
        long ret = (long)(Math.pow(2,s.length()));
        return ret;
    }
    
    public static long getGreatestPowerOfTwoBelow(long i)
    {
        String s = Long.toBinaryString(i);
        long ret = (long)(Math.pow(2,s.length()));
        ret/=2;
        return ret-1;
    }
    
    public static boolean isEvenBinaryOneCount(String s)
    {
        int total = 0;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i)=='1')
                total++;
        return total%2==0;
    }
}