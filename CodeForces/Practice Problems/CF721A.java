import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF721A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numSquares = Integer.parseInt(f.readLine());
        String line = f.readLine();
        
        ArrayList<Integer> groups = new ArrayList<Integer>();
        
        int curLen = 0;
        int numGroups = 0;
        
        for(int i = 0; i < numSquares; i++)
        {
            char cur = line.charAt(i);
            if(cur=='W')
            {
                if(curLen!=0)
                {
                    groups.add(curLen);
                    numGroups++;
                    curLen = 0;
                }
            }
            else
            {
                curLen++;
            }
        }
        
        if(curLen>0)
        {
            groups.add(curLen);
            numGroups++;
        }
        
        output = ""+numGroups+"\n";
        for(int n : groups)
            output += n + " ";
        output = output.substring(0,output.length()-1);
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}