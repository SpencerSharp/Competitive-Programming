import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF519A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int wT = 0;
        int bT = 0;
        
        String line;
        StringTokenizer st;
        for(int r = 0; r < 8; r++)
        {
            line = f.readLine();
            for(int c = 0; c < 8; c++)
            {
                char piece = line.charAt(c);
                switch(piece)
                {
                    case 'Q': wT += 9; break;
                    case 'q': bT += 9; break;
                    case 'R': wT += 5; break;
                    case 'r': bT += 5; break;
                    case 'B': wT += 3; break;
                    case 'b': bT += 3; break;
                    case 'N': wT += 3; break;
                    case 'n': bT += 3; break;
                    case 'P': wT += 1; break;
                    case 'p': bT += 1; break;
                }
            }
        }
        output = wT > bT ? "White" : bT > wT ? "Black" : "Draw";
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}