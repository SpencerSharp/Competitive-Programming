import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF459A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        
        
        int x3;
        int y3;
        int x4;
        int y4;
        if(y1==y2) //Case: Given A,B
        {
            int side = Math.abs(x1-x2);
            x3 = x1;
            y3 = y1 + side;
            x4 = x2;
            y4 = y1+side;
        }
        else if(x1==x2) //Case: Given A,C
        {
            int side = Math.abs(y1-y2);
            x3 = x1 + side;
            y3 = y1;
            x4 = x1 + side;
            y4 = y2;
        }
        else //Case: Given A,D
        {
            x3 = x1;
            y3 = y2;
            x4 = x2;
            y4 = y1;
        }
        output = x3 + " " + y3 + " " + x4 + " " + y4;
        
        if(!isSquare(x1,x2,x3,x4,y1,y2,y3,y4))
            output = "-1";
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean isSquare(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4)
    {
        if(x1==x2)
        {
            if(x3==x4)
            {
                if(y2==y3)
                {
                    if(y1==y4)
                    {
                        int side = Math.abs(x2-x3);
                        if(side==Math.abs(x1-x4))
                        {
                            if(side==Math.abs(y1-y2) && side==Math.abs(y3-y4))
                            {
                                return true;
                            }
                        }
                    }
                }
                if(y1==y3)
                {
                    if(y2==y4)
                    {
                        int side = Math.abs(x1-x3);
                        if(side==Math.abs(x2-x4))
                        {
                            if(side==Math.abs(y1-y2) && side==Math.abs(y3-y4))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if(x1==x3)
        {
            if(x2==x4)
            {
                if(y1==y2)
                {
                    if(y3==y4)
                    {
                        int side = Math.abs(x1-x2);
                        if(side==Math.abs(x3-x4))
                        {
                            if(side==Math.abs(y1-y3) && side==Math.abs(y2-y4))
                            {
                                return true;
                            }
                        }
                    }
                }
                if(y1==y4)
                {
                    if(y2==y3)
                    {
                        int side = Math.abs(x1-x4);
                        if(side==Math.abs(x2-x3))
                        {
                            if(side==Math.abs(y1-y3) && side==Math.abs(y2-y4))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if(x1==x4)
        {
            if(x2==x3)
            {
                if(y1==y2)
                {
                    if(y3==y4)
                    {
                        int side = Math.abs(x1-x2);
                        if(side==Math.abs(x3-x4))
                        {
                            if(side==Math.abs(y1-y4) && side==Math.abs(y2-y3))
                            {
                                return true;
                            }
                        }
                    }
                }
                if(y1==y3)
                {
                    if(y2==y4)
                    {
                        int side = Math.abs(x1-x3);
                        if(side==Math.abs(x2-x4))
                        {
                            if(side==Math.abs(y1-y4) && side==Math.abs(y2-y3))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}