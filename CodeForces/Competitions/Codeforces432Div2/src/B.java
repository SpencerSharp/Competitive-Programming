import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class B
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        
        double dx = ax + ((((double)cx)-((double)ax))/2);
        double dy = ay + ((((double)cy)-((double)ay))/2);
        
        //out.println(dx);
        //out.println(dy);
            //double m = (by-dy)/(bx-dx);
            double t = distBetweenPoints(ax,ay,bx,by)/distBetweenPoints(bx,by,dx,dy);
            //out.println(t);
            double centerX = ((1-t)*bx+t*dx);
            out.println((1-t)*bx);
            out.println(t*dx);
            double centerY = ((1-t)*by+t*dy);
            out.println(centerX);
            out.println(centerY);
            double angle1 = Math.atan2(by,bx) - Math.atan2(ay,ax);
            double angle2 = Math.atan2(cy,cx) - Math.atan2(by,bx);
            if(angle1==angle2 && distBetweenPoints(ax,ay,centerX,centerY)==distBetweenPoints(bx,by,centerX,centerY) && distBetweenPoints(ax,ay,centerX,centerY)==distBetweenPoints(cx,cy,centerX,centerY))
            {
                output = "Yes";
            }
            else
                output = "No";
        
        
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static double distBetweenPoints(double ax, double ay, double bx, double by)
    {
        double result = ((bx-ax)*(bx-ax))+((by-bx)*(by-bx));
        if(result > 0)
            return Math.sqrt(result);
        else
            return -1;
    }
}