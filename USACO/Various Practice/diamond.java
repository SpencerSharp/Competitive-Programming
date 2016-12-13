/*
ID: spencer16
LANG: JAVA
PROG: diamond
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class diamond
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        String line;
        StringTokenizer st;
        line = f.readLine();
        st = new StringTokenizer(line);
        int size = Integer.parseInt(st.nextToken());
        int maxDiff = Integer.parseInt(st.nextToken());
        int[] ray = new int[10001];
        for(int i = 0; i < size; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            ray[Integer.parseInt(st.nextToken())]++;
        }
        int curNum = 0;
        for(int i = 1; i <= maxDiff+1; i++)
        {
            curNum += ray[i];
        }
        int max = curNum;
        for(int i = 2; i < 10001-maxDiff; i++)
        {
            curNum -= ray[i-1];
            curNum += ray[i+maxDiff];
            if(curNum > max)
                max = curNum;
        }
        
        
        
        //Code here

        //out.println(max);
        
        writer.println(max);
        writer.close();
        System.exit(0);
        
    }
}
