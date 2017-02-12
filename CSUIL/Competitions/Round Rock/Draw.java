import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Draw {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("draw.dat"));
        int circX = Integer.parseInt(sc.next());
        int circY = Integer.parseInt(sc.next());
        double circRad = ((double)Integer.parseInt(sc.next()))/2;
        int rectX = Integer.parseInt(sc.next());
        int rectY = Integer.parseInt(sc.next());
        int rectW = Integer.parseInt(sc.next());
        int rectL = Integer.parseInt(sc.next());
        int circleCenterX = (int)(circX + circRad);
        int circleCenterY = (int)(circY + circRad);
        while(sc.hasNext())
        {
            int x = Integer.parseInt(sc.next());
            int y = Integer.parseInt(sc.next());
            if(x >=rectX && x <= rectX + rectW &&
                    y >= rectY && y <= rectY + rectL)
            {
                out.println("rectangle");
            }
            else if(distBetweenPoints(x,y,circleCenterX,circleCenterY)<=circRad)
                out.println("circle");
            else
                out.println("neither");
        }
    }
    
    public static double distBetweenPoints(int x1, int y1, int x2, int y2)
    {
        int xDiff = Math.abs(x2-x1);
        int yDiff = Math.abs(y2-y1);
        return Math.hypot(xDiff, yDiff);
    }
}