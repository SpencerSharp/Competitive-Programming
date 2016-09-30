import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        int numLoops = Integer.parseInt(line);
        StringTokenizer st = new StringTokenizer(line);
        for(int l = 0; l < numLoops; l++)
        {
            f.readLine();
            line = f.readLine();
            st = new StringTokenizer(line);
            int numGodzillas = Integer.parseInt(st.nextToken());
            int numMechas = Integer.parseInt(st.nextToken());
            line = f.readLine();
            st = new StringTokenizer(line);
            PriorityQueue<Integer> godzilla = new PriorityQueue<Integer>();
            for(int i = 0; i < numGodzillas; i++)
            {
                godzilla.add(Integer.parseInt(st.nextToken()));
            }
            line = f.readLine();
            st = new StringTokenizer(line);
            PriorityQueue<Integer> mecha = new PriorityQueue<Integer>();
            for(int i = 0; i < numMechas; i++)
            {
                mecha.add(Integer.parseInt(st.nextToken()));
            }
            while(godzilla.size()>0&&mecha.size()>0)
            {
                int num1 = godzilla.peek();
                int num2 = mecha.peek();
                if(num1<num2)
                    godzilla.remove();
                else if(num2<=num1)
                    mecha.remove();
            }
            if(godzilla.size()==0)
                out.println("MechaGodzilla");
            else
                out.println("Godzilla");
        }
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
