/*
ID: spencer16
LANG: JAVA
PROG: ABSYS
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class ABSYS
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        String output = ""; //Write all output to this string

        //Code here
        int numLoops = Integer.parseInt(f.readLine());
        for(int i = 0; i < numLoops; i++)
        {
            f.readLine();
            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String[] numbers = new String[3];
            numbers[0] = st.nextToken();
            st.nextToken();
            numbers[1] = st.nextToken();
            st.nextToken();
            numbers[2] = st.nextToken();
            //First argument has machula
            if(numbers[0].contains("machula"))
            {
                int ans = Integer.parseInt(numbers[2])-Integer.parseInt(numbers[1]);
                output = ans + " + " + numbers[1] + " = " + numbers[2];
            }
            //Second argument has machula
            else if(numbers[1].contains("machula"))
            {
                int ans = Integer.parseInt(numbers[2])-Integer.parseInt(numbers[0]);
                output = numbers[0] + " + " + ans + " = " + numbers[2];
            }
            else
            {
                int ans = Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]);
                output = numbers[0] + " + " + numbers[1] + " = " + ans;
            }

            //Code here

            writer.println(output);
        }
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}