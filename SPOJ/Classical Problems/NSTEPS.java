import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class NSTEPS
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int size = Integer.parseInt(f.readLine());
        for(int l = 0; l < size; l++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //out.println(x + " " + y);
            int num = -1;
            if(x==y)
            {
                if(x%2==0)
                {
                    num = x * 2;
                }
                else
                {
                    num = (x*2)-1;
                }
            }
            else
            {
                if(x-2==y)
                {
                    if(x%2==0)
                    {
                        num = ((x-2)*2)+2;
                    }
                    else
                    {
                        num = (((x-2)*2)-1)+2;
                    }
                }
            }
            if(num==-1)
                writer.println("No Number");
            else
                writer.println(num);
        }
        
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
