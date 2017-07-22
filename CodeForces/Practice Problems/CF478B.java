import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF478B
{
    static BigInteger zero = new BigInteger("0");
    static BigInteger one  = new BigInteger("1");
    static BigInteger two  = new BigInteger("2");
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        BigInteger numPeople = new BigInteger(st.nextToken());
        BigInteger numTeams = new BigInteger(st.nextToken());
        
        BigInteger maxTeamSize = numPeople.subtract(numTeams.subtract(new BigInteger("1")));
        BigInteger maxPairs = getPairsFromSize(maxTeamSize);
        
        BigInteger minPairs = new BigInteger("0");
        BigInteger divided = numPeople.divide(numTeams);
        BigInteger remain  = numPeople.mod(numTeams);
        
        //out.println(divided);
        //out.println(remain);
        
        BigInteger count = new BigInteger("0");
        minPairs = minPairs.add(remain.multiply(getPairsFromSize(divided.add(one))));
        minPairs = minPairs.add(numTeams.subtract(remain).multiply(getPairsFromSize(divided)));
        
        output = minPairs + " " + maxPairs;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    static BigInteger getPairsFromSize(BigInteger size)
    {
        BigInteger numPairs;
        if(size.equals(one))
            return zero;
        if(size.mod(two).equals(zero))
        {
            numPairs = size.multiply(size.divide(two).subtract(one)).add(size.divide(two));
        }
        else
        {
            numPairs = size.multiply(size.divide(two));
        }
        return numPairs;
    }
}