import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class F
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int rr = 0;
        int rg = 0;
        int rb = 0;
        
        int gr = 0;
        int gg = 0;
        int gb = 0;
        
        int br = 0;
        int bg = 0;
        int bb = 0;
        
        int num = Integer.parseInt(f.readLine());
        
        String line = "";
        
        for(int i = 0; i < num; i++)
        {
            line = f.readLine();
            switch(line)
            {
                case "R R": rr++; break;
                case "R G": rg++; break;
                case "R B": rb++; break;
                case "G R": gr++; break;
                case "G G": gg++; break;
                case "G B": gb++; break;
                case "B R": br++; break;
                case "B G": bg++; break;
                case "B B": bb++; break;
            }
        }

        int loopCount = 0;
        while(!areWeDone(rr, gg, bb, num))
        {
            loopCount++;
            if(rg > 0)
            {
                if(gr > 0)
                {
                    rg--;
                    gr--;
                    gg++;
                    rr++;
                    continue;
                }
                
            }
            if(rb > 0)
            {
                if(br > 0)
                {
                    rb--;
                    br--;
                    rr++;
                    bb++;
                    continue;
                }
            }
            if(gb > 0)
            {
                if(bg > 0)
                {
                    gb--;
                    bg--;
                    gg++;
                    bb++;
                    continue;
                }
            }
            
            /**
             * 
             * 
             * 
             * 
             */
            if(rg > 0)
            {
                if(gb > 0)
                {
                    gg++;
                    rb++;
                    rg--;
                    gb--;
                    continue;
                }
                else if(br > 0)
                {
                    rr++;
                    gb++;
                    rg--;
                    br--;
                    continue;
                }
            }
            
            if(rb > 0)
            {
                if(gr > 0)
                {
                    rb--;
                    gr--;
                    rr++;
                    gb++;
                    continue;
                }
                else if(bg > 0)
                {
                    bb++;
                    rg++;
                    bg--;
                    rb--;
                }
            }
            
            if(gr > 0)
            {
                if(bg > 0)
                {
                    bg--;
                    gr--;
                    gg++;
                    br++;
                    continue;
                }
            }
            
            if(gb > 0)
            {
                if(br > 0)
                {
                    bb++;
                    gr++;
                    gb--;
                    br--;
                    continue;
                }
            }
            //out.println("Rip");
        }
        output = ""+loopCount;
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean areWeDone(int rr, int gg, int bb, int total)
    {
        if(rr + gg + bb == total)
            return true;
        return false;
    }
}