
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.util.HashSet;

public class WhitespaceParcer {
    public static boolean doesContainAlready(HashSet<String> hs, String line)
    {
        for(String s : hs)
            if(line.equals(s))
                return true;
        return false;
    }
    
    public static int getAVLTreeMin
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("turtle.txt"));
        String line;
        String result = "";
        int total = 0;
        HashSet<String> hs = new HashSet<String>();
        while((line=f.readLine())!=null)
        {
            //out.println(line);
            if(!line.matches("\\s*") && !line.matches(""))
                if(!doesContainAlready(hs,line))
                    total++;
            hs.add(line);
            //out.println(line);
            //out.println();
        }
        out.println(total);
    }
}