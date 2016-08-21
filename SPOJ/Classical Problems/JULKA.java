import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class JULKA
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        //String output = ""; //Write all output to this string

        //Code here
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        for(int i = 0; i < 10; i++)
        {
            BigInteger total = new BigInteger(f.readLine());
            BigInteger diff = new BigInteger(f.readLine());
            if(diff.mod(two).equals(one))
            {
                //out.println("yes");
                BigInteger answerOne = total.divide(two);
                answerOne = answerOne.add(diff.divide(two));
                answerOne = answerOne.add(one);
                BigInteger answerTwo = total.divide(two);
                answerTwo = answerTwo.subtract(diff.divide(two));
                writer.println(answerOne);
                writer.println(answerTwo);
            }
            else
            {
                BigInteger answerOne = total.divide(two);
                answerOne = answerOne.add(diff.divide(two));
                writer.println(answerOne);
                BigInteger answerTwo = total.divide(two);
                answerTwo = answerTwo.subtract(diff.divide(two));
                writer.println(answerTwo);
            }
        }
        
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
