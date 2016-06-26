/*
ID: spencer16
LANG: JAVA
PROG: friday
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class friday
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int day = -1;
        int month = 0;
        int year = 0;
        
        int maxYears = Integer.parseInt(f.readLine());

        int dayOfWeek = 0;
        
        int[] numThirteens = new int[7];
        
        while(year<maxYears)
        {
            while(month<12)
            {
                while(day<getDaysInMonth(month,year))
                {
                    dayOfWeek++;
                    if(dayOfWeek>6)
                        dayOfWeek=0;
                    day++;
                    if(day==13)
                        numThirteens[dayOfWeek]++;
                }
                day = 0;
                month++;
            }
            month = 0;
            year++;
        }
        
        for(int i = 0; i < numThirteens.length; i++)
        {
            output += numThirteens[i];
            if(i<numThirteens.length-1)
                output += " ";
        }
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getDaysInMonth(int month, int year)
    {
        int numDays = -1;
        int truYear = year+1900;
        if(month==3||month==5||month==8||month==10)
            numDays=30;
        else if(month==1)
        {
            if(truYear%400==0 || (truYear%4==0 && truYear%100!=0))
                numDays = 29;
            else
                numDays = 28;
        }
        else
            numDays = 31;
        return numDays;
    }
}
