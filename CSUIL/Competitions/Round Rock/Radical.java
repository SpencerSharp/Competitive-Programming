import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Radical {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("radical.dat"));
        while(sc.hasNext()){
            int outsideRad = 1;
            double inp = (double) Integer.parseInt(sc.next());
            int maxSquare = (int) Math.sqrt(inp);
            
            //out.println(Math.sqrt(inp));
            maxSquare *= maxSquare;
            int cur = (int) inp;
            while(maxSquare > 0)
            {
                //out.println(maxSquare);
                if(cur>=maxSquare && cur%maxSquare==0)
                {
                    //out.println("IF" + cur + " " + maxSquare);
                    cur/=maxSquare;
                    outsideRad *= (int) Math.sqrt(maxSquare);
                }
                maxSquare = maxSquareBelow(maxSquare);
            }
            if(cur==1&&outsideRad==1)
                out.println(cur);
            else if(cur==1)
                out.println(outsideRad);
            else if(outsideRad==1)
                out.println("."+cur);
            else
                out.println(outsideRad + "."+cur);
            //out.println(outsideRad + " " + cur);
        }
    }
    
    public static int maxSquareBelow(int square)
    {
        int cur = 0; int i = 0;
        while(cur<square)
        {
            cur = ++i;
            cur *= cur;
        }
        i--;
        return (i*i);
    }
}