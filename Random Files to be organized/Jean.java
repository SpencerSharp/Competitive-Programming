import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/*
FROM UIL SET A PROGRAMMING PRACTICE
*/
public class Jean {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        int numCases = Integer.parseInt(sc.nextLine());
        for(int curCaseNum = 0; curCaseNum < numCases; curCaseNum++)
        {
            int numStops = Integer.parseInt(sc.nextLine());
            boolean[] isVisited = new boolean[numStops];
            boolean[] isLeft = new boolean[numStops];
            ArrayList<String> lines = new ArrayList<String>();
            for(int curStop = 0; curStop < numStops; curStop++)
            {
                lines.add(sc.nextLine());
            }
            ArrayList<String> identifiers = new ArrayList<String>();
            for(int curStop = 0; curStop < numStops; curStop++)
            {
                identifiers.add(lines.get(curStop).substring(0,lines.get(curStop).indexOf("->")-1));
            }
            for(int curStop = 0; curStop < numStops; curStop++)
            {
                for(int i = 0; i < identifiers.size(); i++)
                {
                    if(lines.get(curStop).substring(lines.get(curStop).indexOf("->")).contains(identifiers.get(i)))
                        isVisited[i] = true;//lines.get(curStop).substring(lines.get(curStop).indexOf("->")).contains(identifiers.get(i));
                }
                isLeft[curStop] = !lines.get(curStop).substring(lines.get(curStop).indexOf(">")+1).contains("NONE");
            }
            boolean[] isSource = new boolean[numStops];
            boolean[] isSink = new boolean[numStops];
            for(int i = 0; i < identifiers.size(); i++)
            {
                if(isVisited[i] && !isLeft[i])
                    isSink[i] = true;
                if(!isVisited[i] && isLeft[i])
                    isSource[i] = true;
            }
            TreeSet<String> sources = new TreeSet<String>();
            String disp = "";
            for(int i = 0; i < identifiers.size(); i++)
            {
                if(isSource[i])
                    sources.add(identifiers.get(i));
            }
            for(String s : sources)
                disp += s + " ";
            if(disp.length()>0)
                disp = disp.substring(0,disp.length()-1);
            if(disp.equals(""))
                disp = "NONE";
            out.println("Sources " + disp);
            TreeSet<String> sinks = new TreeSet<String>();
            disp = "";
            for(int i = 0; i < identifiers.size(); i++)
            {
                if(isSink[i])
                    sinks.add(identifiers.get(i));
            }
            for(String s : sinks)
                disp += s + " ";
            if(disp.length()>0)
                disp = disp.substring(0,disp.length()-1);
            if(disp.equals(""))
                disp = "NONE";
            out.println("Sources " + disp);
        }
    }
}