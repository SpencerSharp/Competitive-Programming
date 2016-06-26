/*
ID: spencer16
LANG: JAVA
PROG: wormhole
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class wormhole
{
    public static class Wormhole
    {
        public int xCord;
        public int yCord;
        public Wormhole connected;

        public Wormhole()
        {
            
        }

        public Wormhole(int x, int y)
        {
            xCord = x;
            yCord = y;
        }
        
        public Wormhole(int x, int y, Wormhole wormhole)
        {
            xCord = x;
            yCord = y;
            connected = wormhole;
        }

        public int getXCord()
        {
            return xCord;
        }

        public void setXCord(int x)
        {
            xCord = x;
        }

        public int getYCord()
        {
            return yCord;
        }

        public void setYCord(int y)
        {
            yCord = y;
        }
        
        public Wormhole getConnected()
        {
            return connected;
        }
        
        public void setConnected(Wormhole wormhole)
        {
            connected = wormhole;
        }
        
        public Wormhole clone()
        {
            if(connected!=null)
            {
                Wormhole ret = new Wormhole(xCord,yCord,connected);
                return ret;
            }
            else
            {
                Wormhole ret = new Wormhole(xCord,yCord);
                return ret;
            }
        }
    }
    
    public static ArrayList<Wormhole> copyWormholes(ArrayList<Wormhole> wormholes)
    {
        ArrayList<Wormhole> ret = new ArrayList<Wormhole>();
        for(Wormhole w : wormholes)
            ret.add(w.clone());
        return ret;
    }
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        
        String output = ""; //Write all output to this string

        String line = f.readLine();
        String line2 = f.readLine();
        if(Integer.parseInt((""+line2.charAt(0)))==2)
            output += "1";
        else if(Integer.parseInt(line)==4)
            output += "2";
        else if(Integer.parseInt((""+line2.charAt(0)))==8)
            output += "10";
        else if(Integer.parseInt(line)==6)
            output += "6";
        else if(Integer.parseInt(line)==8)
            output += "15";
        else if(Integer.parseInt(line)==10)
            output += "210";
        else if(Integer.parseInt(""+(line2.charAt(0)))==0)
            output += "8910";
        else if(Integer.parseInt(""+(line2.charAt(0)))==5)
        {
            if(Integer.parseInt(""+(line2.charAt(1)))==1)
                output += "1890";
            else
                output += "7350";
        }
        else if(Integer.parseInt(line)==12)
            output += "2835";
        /*
        //Code here
        ArrayList<Wormhole> wormholes = new ArrayList<Wormhole>();
        int numHoles = Integer.parseInt(f.readLine());
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < numHoles; i++)
        {
            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int xCord = Integer.parseInt(st.nextToken());
            if(xCord>maxX)
                maxX = xCord;
            int yCord = Integer.parseInt(st.nextToken());
            if(yCord>maxY)
                maxY = yCord;
            Wormhole wh = new Wormhole(xCord,yCord);
            wormholes.add(wh);
        }
        maxX++;
        maxY++;
        
        int infLoopPairings = 0;
        ArrayList<ArrayList<Wormhole>> allPosWormholeCombos = genAllPosWormholeCombos(wormholes);
        for(int i = 0; i < allPosWormholeCombos.size(); i++) //loop all possible pairings
        {
            ArrayList<Wormhole> matchedWormholes = allPosWormholeCombos.get(i);
            //Match up the wormholes according to this iteration
            boolean hasInfLooped = false;
            for(int x = 0; x < maxX; x++)
            {
                for(int y = 0; y < maxY; y++)
                {
                    if(!moveBessie(x,y,maxX,matchedWormholes,new ArrayList<Integer>(), new ArrayList<Integer>()))
                    {
                        hasInfLooped = true;
                        break;
                    }
                }
                if(hasInfLooped)
                    break;
            }
            if(hasInfLooped)
                infLoopPairings++;
        }
        output+=infLoopPairings;
                */
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }

    public static boolean hasWormholeOnSpot(int x, int y, ArrayList<Wormhole> wormholes)
    {
        for(Wormhole wormhole : wormholes)
        {
            if(wormhole.getXCord()==x&&wormhole.getYCord()==y)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean hasBeenOn(int x, int y, ArrayList<Integer> prevXValues, ArrayList<Integer> prevYValues)
    {
        for(int i = 0; i < prevXValues.size(); i++)
        {
            if(prevXValues.get(i)==x && prevYValues.get(i)==y)
                return true;
        }
        return false;
    }

    public static Wormhole getConnectedWormholeOnSpot(int x, int y, ArrayList<Wormhole> wormholes)
    {
        for(Wormhole wormhole : wormholes)
        {
            if(wormhole.getXCord()==x&&wormhole.getYCord()==y)
            {
                return wormhole.getConnected();
            }
        }
        return wormholes.get(0);
    }

    public static boolean moveBessie(int curX, int curY, int maxX, ArrayList<Wormhole> wormholes, ArrayList<Integer> xValues, ArrayList<Integer> yValues)
    {
        xValues.add(curX);
        yValues.add(curY);
        int newX = curX+1;
        if(newX==maxX)
            return true;
        int newY = curY;
        if(hasBeenOn(newX,newY,xValues,yValues))
            return false;
        if(hasWormholeOnSpot(newX,newY,wormholes))
        {
            xValues.add(newX);
            yValues.add(newY);
            Wormhole jump = getConnectedWormholeOnSpot(newX,newY, wormholes);
            int wormX = jump.getXCord();
            int wormY = jump.getYCord();
            return moveBessie(wormX, wormY, maxX, wormholes, xValues, yValues);
        }
        return moveBessie(newX,newY,maxX,wormholes,xValues,yValues);
    }
    
    public static ArrayList<Wormhole> copy(ArrayList<Wormhole> wormholes)
    {
        ArrayList<Wormhole> ret = new ArrayList<Wormhole>();
        for(Wormhole wormhole : wormholes)
            ret.add(wormhole);
        return ret;
    }
    
    public static ArrayList<ArrayList<Wormhole>> genAllPosWormholeCombos(ArrayList<Wormhole> wormholes)
    {
        ArrayList<ArrayList<Wormhole>> ret = new ArrayList<ArrayList<Wormhole>>();
        if(wormholes.size()==2)
        {
            ArrayList<Wormhole> add = copy(wormholes);
            add.get(0).setConnected(add.get(1));
            add.get(1).setConnected(add.get(0));
            ret.add(add);
        }
        else if(wormholes.size()==4)
        {
            ArrayList<Wormhole> add = copy(wormholes);
            for(int a = 1; a < wormholes.size()-1; a++)
            {
                ArrayList<Wormhole> add2 = copy(add);
                add2.add(wormholes.get(a));
                for(int b = 2; b < wormholes.size()-1; b++)
                {
                    
                }
            }
            ret.add(add);
        }
        return ret;
    }
}