import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Yoda {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("yoda.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int loop = 0; loop < numLoops; loop++) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            String endLine = "";
            for(int i = 0; i < 2; i++)
            {
                if(i<1)
                    endLine += st.nextToken() + " ";
                else
                    endLine += st.nextToken();
            }
            String startLine = "";
            while(st.hasMoreTokens())
            {
                startLine += st.nextToken() + " ";
            }
            startLine += endLine;
            out.println(startLine);
        }
    }
}