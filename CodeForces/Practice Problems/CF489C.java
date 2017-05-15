import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF489C
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        boolean specialCaseIsHere = m==1 && s==0;
        if(!specialCaseIsHere && (s > m*9 || s==0 && m!=0))
            output = "-1 -1";
        else
        {
            int tempM = m;
            int tempS = s;
            for(int i = 0; i < m; i++)
            {
                if(tempM==1)
                {
                    output += tempS;
                    tempM--;
                }
                else
                {
                    //out.println(tempM);
                    //out.println(tempS);
                    //out.println((tempS-1)/(tempM-1));
                    //out.println();
                    if(((tempS-1)/(tempM-1))>=9)
                    {
                        int num = tempS - (9*(tempM-1));
                        output += num;
                        tempS-=num;
                    }
                    else if(i==0)
                    {
                        output += "1";
                        tempS -= 1;
                    }
                    else
                    {
                        output += "0";
                    }
                    //out.println("OUT"+output);
                    tempM--;
                }
            }
            output += " ";
            tempM = m;
            tempS = s;
            for(int i = 0; i < m; i++)
            {
                if(tempS == 0)
                {
                    output += "0";
                }
                else if(tempS < 9)
                {
                    output += tempS;
                    tempS = 0;
                }
                else
                {
                    output += "9";
                    tempS -= 9;
                }
            }
        }
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
