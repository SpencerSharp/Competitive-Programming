import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
FROM UIL SET A PROGRAMMING PRACTICE
*/
public class Htoo {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        int loopTimes = Integer.parseInt(sc.nextLine());
        for(int loopVal = 0; loopVal < loopTimes; loopVal++)
        {
            String line = sc.nextLine();
            int l1x1 = Integer.parseInt(line.substring(line.indexOf("(")+1,line.indexOf(",")));
            int l1y1 = Integer.parseInt(line.substring(line.indexOf(",")+2,line.indexOf(")")));
            int l1x2 = Integer.parseInt(line.substring(line.lastIndexOf("(")+1,line.lastIndexOf(",")));
            int l1y2 = Integer.parseInt(line.substring(line.lastIndexOf(",")+2,line.lastIndexOf(")")));
            if(l1x2 < l1x1)
            {
                int temp = l1x1;
                l1x1 = l1x2;
                l1x2 = temp;
                temp = l1y1;
                l1y1 = l1y2;
                l1y2 = temp;
            }
            int l1yMulti = 1;
            if(l1y2 < l1y1)
                l1yMulti = -1;
            line = sc.nextLine();
            int l2x1 = Integer.parseInt(line.substring(line.indexOf("(")+1,line.indexOf(",")));
            int l2y1 = Integer.parseInt(line.substring(line.indexOf(",")+2,line.indexOf(")")));
            int l2x2 = Integer.parseInt(line.substring(line.lastIndexOf("(")+1,line.lastIndexOf(",")));
            int l2y2 = Integer.parseInt(line.substring(line.lastIndexOf(",")+2,line.lastIndexOf(")")));
            if(l2x2 < l2x1)
            {
                int temp = l2x1;
                l2x1 = l2x2;
                l2x2 = temp;
                temp = l2y1;
                l2y1 = l2y2;
                l2y2 = temp;
            }
            int l2yMulti = 1;
            if(l2y2 < l2y1)
                l2yMulti = -1;
            //out.println(l1x1 + " " + l1y1 + " " + l1x2 + " " + l1y2);
            boolean doesCross = false;
            for(int l1curX = l1x1; l1curX <= l1x2; l1curX++)
            {
                int l1curY = l1y1 + (l1curX-l1x1)*l1yMulti;
                //out.println(l1curX + " " + l1curY);
                for(int l2curX = l2x1; l2curX <= l2x2; l2curX++)
                {
                    int l2curY = l2y1 + (l2curX-l2x1)*l2yMulti;
                    //out.println(l2curX + " " + l2curY);
                    if(l1curX == l2curX && l1curY == l2curY)
                        doesCross = true;
                }
            }
            out.println(doesCross?"INTERSECT":"NO INTERSECTION");
        }
    }
}