import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF349A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numPeople = Integer.parseInt(f.readLine());
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int num25s = 0;
        int num50s = 0;
        
        boolean failed = false;
        
        for(int i = 0; i < numPeople; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            if(num==25)
            {
                num25s++;
            }
            else if(num==50)
            {
                num25s--;
                num50s++;
            }
            else if(num==100)
            {
                if(num50s>0)
                {
                    num50s--;
                    num25s--;
                }
                else
                {
                    num25s -= 3;
                }
            }
            if(isBad(num25s,num50s))
                failed = true;
        }
        
        output = failed?"NO":"YES";
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean isBad(int num1, int num2)
    {
        if(num1 < 0 || num2 < 0)
            return true;
        return false;
    }
}