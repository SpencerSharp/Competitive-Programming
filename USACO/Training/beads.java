/*
ID: spencer16
LANG: JAVA
PROG: beads
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class beads
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int numBeads = Integer.parseInt(f.readLine());
        String necklace = f.readLine();
        necklace += necklace;
        int max = 0;
        int index = 0;
        for(int l = 0; l < necklace.length()-1; l++)
        {
            int cur = l;
            char curChar = necklace.charAt(l);
            if(curChar=='w')
            {
                int tempInd = l+1;
                while(tempInd<necklace.length() && curChar=='w')
                {
                    curChar = necklace.charAt(tempInd);
                    tempInd++;
                }
                cur = tempInd-1;
            }
            //if(l==19)
            //    out.println(cur+""+curChar);
            while(cur < necklace.length()-1 && (necklace.charAt(cur+1)==curChar || necklace.charAt(cur+1)=='w'))
                cur++;
            if(cur+1<necklace.length()-1)
            {
                curChar = necklace.charAt(cur+1);
                //if(l==19)
                //    out.println(cur+""+curChar);
                while(cur < necklace.length()-1 && (necklace.charAt(cur+1)==curChar || necklace.charAt(cur+1)=='w'))
                    cur++;
                //out.println(l + " " + cur);
            }
            if(cur-l > max)
            {
                max = cur-l;
                index = l;
            }
        }
        //out.println(index + " " + necklace.substring(0,index));
        if(max+1>numBeads)
            output += numBeads;
        else
            output += max+1;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
