import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class C
{
    static class Point
    {
        int a;
        int b;
        int c;
        int d;
        int e;
        
        public Point()
        {
            
        }
        
        public Point(int a, int b, int c, int d, int e)
        {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
    
    static class Vector
    {
        Point a;
        Point b;
        
        public Vector(Point a, Point b)
        {
            this.a = a;
            this.b = b;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numPoints = Integer.parseInt(f.readLine());
        
        StringTokenizer st;
        
        HashMap<Integer,Point> points = new HashMap<Integer,Point>();
        HashMap<Integer,Point> goodPoints = new HashMap<Integer,Point>();
        
        for(int i = 0; i < numPoints; i++)
        {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Point p = new Point(a,b,c,d,e);
            
            points.put(i,p);
            goodPoints.put(i,p);
        }
        for(int i = 0; i < numPoints; i++) //Loop thru a
        {
            Point a = points.get(i);
            if(goodPoints.get(i)!=null)
            {
                for(int j = i+1; j < numPoints; j++) //Loop thru b
                {
                    Point b = points.get(j);
                    for(int k = j+1; k < numPoints; k++) //Loop thru c
                    {
                        Point c = points.get(k);
                        double angle = getAngleBetween(a,b,c);
                        double angle4 = getAngleBetween(b,c,a);
                        double angle6 = getAngleBetween(c,b,a);
                        
                        if(angle4 < 90.0)
                        {
                            goodPoints.remove(j);
                        }
                        if(angle6 < 90.0)
                        {
                            goodPoints.remove(k);
                        }
                        if(angle < 90.0)
                        {
                            goodPoints.remove(i);
                            j = numPoints;
                            k = numPoints;
                        }
                    }
                }
            }
        }
        
        int numGoodPoints = goodPoints.size();
        writer.println(numGoodPoints);
        TreeSet<Integer> indices = new TreeSet<Integer>();
        for(int i = 0; i < numPoints; i++)
        {
            if(goodPoints.get(i)!=null)
            {
                indices.add(i);
            }
        }
        for(int n : indices)
            writer.println((n+1));
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static double getAngleBetween(Point a, Point b, Point c)
    {
        Vector v1 = new Vector(a,b);
        Vector v2 = new Vector(a,c);
        
        double top = dotProduct(v1,v2);
        double bottom = Math.sqrt(dotProduct(v1,v1)) * Math.sqrt(dotProduct(v2,v2));
        
        //out.println(""+(top/bottom));
        
        return Math.toDegrees(Math.acos(top/bottom));
    }
    
    public static double dotProduct(Vector a, Vector b)
    {
        double result = 0;
        result += (a.b.a-a.a.a)*(b.b.a-b.a.a);
        result += (a.b.b-a.a.b)*(b.b.b-b.a.b);
        result += (a.b.c-a.a.c)*(b.b.c-b.a.c);
        result += (a.b.d-a.a.d)*(b.b.d-b.a.d);
        result += (a.b.e-a.a.e)*(b.b.e-b.a.e);
        
        return result;
    }
}