/*
ID: spencer16
LANG: JAVA
PROG: hamming
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class hamming
{
    public static int numBits;
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        numBits = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> codes = new ArrayList<Integer>();
        //out.println(getHammingDistance(0,1));
        codes = findCodes(codes, -1, numBits, d, n);
        
        for(int i = 1; i <= codes.size(); i++)
        {
            if(i%10==0)
                output += codes.get(i-1) + "\n";
            else
                output += codes.get(i-1) + " ";
        }
        
        output = output.substring(0,output.length()-1);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static ArrayList<Integer> findCodes(ArrayList<Integer> curCodes, int cMax, int bits, int d, int numReq)
    {
        if(curCodes.size()==numReq)
            return curCodes;
        for(int i = cMax+1; i <= Math.pow(2,bits); i++)
        {
            boolean isValid = true;
            for(int j = 0; j < curCodes.size(); j++)
            {
                int dist = getHammingDistance(curCodes.get(j),i);
                if(dist<d)
                {
                    isValid = false;
                }
            }
            if(isValid)
            {
                ArrayList<Integer> newCodes = new ArrayList<Integer>();
                for(int n = 0; n < curCodes.size(); n++)
                {
                    newCodes.add(curCodes.get(n));
                }
                newCodes.add(i);
                ArrayList<Integer> res = findCodes(newCodes,i,bits,d,numReq);
                if(res.size()==numReq)
                {
                    return res;
                }
            }
        }
        return curCodes;
    }
    
    public static int getHammingDistance(int n1, int n2)
    {
        int hamDist = n1 ^ n2;
        String binS = Integer.toBinaryString(hamDist);
        int count = 0;
        for(int i = 0; i < binS.length(); i++)
        {
            if(binS.charAt(i)=='1')
                count++;
        }
        return count;
    }
}
