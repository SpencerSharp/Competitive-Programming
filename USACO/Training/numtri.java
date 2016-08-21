/*
ID: spencer16
LANG: JAVA
PROG: numtri
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class numtri
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int sizeOfPyramid = Integer.parseInt(f.readLine());
        int[][] pyramid = new int[sizeOfPyramid][sizeOfPyramid];
        for(int i = 0; i < sizeOfPyramid; i++)
        {
            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for(int j = 0; j <= i; j++)
            {
                if(i > 0 && (j >= 1 && j != i))
                    pyramid[i][j] = Integer.parseInt(st.nextToken()) + Math.max(pyramid[i-1][j-1],pyramid[i-1][j]);
                else if(i > 0 && j == 0)
                    pyramid[i][j] = Integer.parseInt(st.nextToken()) + pyramid[i-1][j];
                else if(i > 0)
                    pyramid[i][j] = Integer.parseInt(st.nextToken()) + pyramid[i-1][j-1];
                else
                    pyramid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for(int i = 0; i < sizeOfPyramid; i++)
        {
            int num = pyramid[sizeOfPyramid-1][i];
            //out.println(num);
            if(num>max)
                max = num;
        }
        output = ""+max;
        
        //Code here
        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getMaxFromPyramidLevel(int index, int level, int[][] pyramid)
    {
        int curNum = pyramid[level][index];
        if(level==0)
            return curNum;
        if(index > 0 && index < level-1)
        {
            if(level <= 20)
            {
                int n1 = getMaxFromPyramidLevel(index-1,level-1,pyramid);
                int n2 = getMaxFromPyramidLevel(index,level-1,pyramid);
                return curNum + Math.max(n1,n2);
            }
            else
            {
                int n1 = pyramid[level-1][index];//getMaxFromPyramidLevel(index-1,level-1,pyramid);
                int n2 = pyramid[level-1][index-1];//getMaxFromPyramidLevel(index,level-1,pyramid);
                if(n1>n2)
                    return curNum + getMaxFromPyramidLevel(index,level-1,pyramid);
                else
                    return curNum + getMaxFromPyramidLevel(index-1,level-1,pyramid);
            }
            
            //return curNum + Math.max(n1,n2);
        }
        else if(index ==0)
            return curNum + getMaxFromPyramidLevel(index,level-1,pyramid);
        else
            return curNum + getMaxFromPyramidLevel(index-1,level-1,pyramid);
    }
}