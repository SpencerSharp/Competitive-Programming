/*
ID: spencer16
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class ride
{
    public static void main(String[] args) throws IOException
    {
        //Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));

        Scanner sc = new Scanner(new File("ride.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String output = ""; //Write all output to this string
        
        //Code here
        String com1 = sc.next();
        String com2 = sc.next();

        long total1 = 1;
        for(char a : com1.toCharArray())
            total1*=a-'A'+1;

        long total2 = 1;
        for(char a : com2.toCharArray())
            total2*=a-'A'+1;

        if(total1%47==total2%47)
            output += "GO";
        else
            output += "STAY";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
    }
}