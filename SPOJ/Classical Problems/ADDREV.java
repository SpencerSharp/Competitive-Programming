import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class ADDREV
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long size = Long.parseLong(f.readLine());
        for(int n = 0; n < size; n++)
        {
            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            long n1 = Long.parseLong(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());
            long disp = reverse(reverse(n1)+reverse(n2));
            output += disp + "\n";
        }
        output = output.substring(0,output.length()-1);
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static long reverse(long num)
    {
        String nString = ""+num;
        String ret = "";
        boolean hasNormalNumBeenFound = false;
        for(int i = nString.length()-1; i >= 0; i--)
        {
            char c = nString.charAt(i);
            if(c!='0')
                hasNormalNumBeenFound = true;
            if(c!='0'||hasNormalNumBeenFound)
                ret += nString.charAt(i);
        }
        return Long.parseLong(ret);
    }
}
