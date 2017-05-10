import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF189A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int loops = 4000*4000*4000;
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int max = 0;
        int length = Integer.parseInt(st.nextToken());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        int a = 0;
        int b = 0;
        int c = 0;
        int aTotal = 0;
        int bTotal = 0;
        for(a=0; a <= length/num1; ++a)
        {
            aTotal = num1*a;
            for(b=0; b <= (length-aTotal)/num2; ++b)
            {
                bTotal = aTotal + num2*b;
                c = (length-bTotal)/num3;
                if(bTotal + c*num3 == length)
                    if(a+b+c>max)
                        max = a+b+c;
            }
            //out.println(a);
        }
        output = ""+max;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
