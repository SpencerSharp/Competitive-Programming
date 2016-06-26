import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class ACPC10A
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        boolean canContinue = true;
        while(canContinue)
        {
            StringTokenizer st = new StringTokenizer(line);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            //Try AP
            if(!(n1==0&&n2==0&&n3==0))
            {
                if(n2-n1==n3-n2 && (n2-n1!=0))
                    writer.println("AP " + (n3 + (n2-n1)));
                else
                    writer.println("GP " + (n3 * (n2/n1)));
            }
            else
                canContinue = false;
            line = f.readLine();
        }
        
        
        
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
        
    }
}
