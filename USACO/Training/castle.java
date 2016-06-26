/*
ID: spencer16
LANG: JAVA
PROG: castle
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class castle
{
    public static class Square
    {
        int x;
        int y;
        public Square north;
        public Square west;
        public Square east;
        public Square south;
        boolean visited;
        
        public Square(int nX, int nY)
        {
            x = nX;
            y = nY;
            visited = false;
        }
        
        public void addNorth(Square newNorth)
        {
            north = newNorth;
        }
        
        public Square getNorth()
        {
            return north;
        }
        
        public void addWest(Square newWest)
        {
            west = newWest;
        }
        
        public Square getWest()
        {
            return west;
        }
        
        public void addEast(Square newEast)
        {
            east = newEast;
        }
        
        public Square getEast()
        {
            return east;
        }
        
        public void addSouth(Square newSouth)
        {
            south = newSouth;
        }
        
        public Square getSouth()
        {
            return south;
        }
        
        public boolean setVisited()
        {
            visited = true;
        }
        
        public boolean hasBeenVisited()
        {
            return visited;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        */
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        Square[][] castle = new Square[y][x];
        for(int i = 0; i < y; i++)
        {
            for(int j = 0; j < x; j++)
            {
                castle[i][j] = new Square(i,j);
            }
        }
        for(int j = 0; j < y; j++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            for(int i = 0; i < x; i++)
            {
                int num = Integer.parseInt(st.nextToken());
                String binaryRep = Integer.toBinaryString(num);
                
                out.println(num + " " +j + " " + i + " " + binaryRep);
                if(binaryRep.length() < 1 || binaryRep.charAt(binaryRep.length()-1)=='0') //If no wall to west
                {
                    castle[j][i].addWest(castle[j][i-1]);
                    castle[j][i-1].addEast(castle[j][i]);
                }
                if(binaryRep.length() < 2 || binaryRep.charAt(binaryRep.length()-2)=='0') //If no wall to north
                {
                    castle[j][i].addNorth(castle[j-1][i]);
                    castle[j-1][i].addSouth(castle[j][i]);
                }
                if(binaryRep.length() < 3 || binaryRep.charAt(binaryRep.length()-3)=='0') //If no wall to east
                {
                    castle[j][i].addEast(castle[j][i+1]);
                    castle[j][i+1].addWest(castle[j][i]);
                }
                if(binaryRep.length() < 4 || binaryRep.charAt(binaryRep.length()-4)=='0') //If no wall to south
                {
                    castle[j][i].addSouth(castle[j+1][i]);
                    castle[j+1][i].addNorth(castle[j][i]);
                }
            }
        }
        
        int numBeenVisited = totalVisited(castle);
        ArrayList<Integer> rooms = new ArrayList<Integer>();
        while(numBeenVisited < x*y)
        {
            Square notBeenVisited = getOneVisited(castle);
            
            castle[notBeenVisited.x][notBeenVisited.y].setVisited();
            if(notBeenVisited.getNorth()!=null)
            {
                castle = recurseOn(notBeenVisited.getNorth(),castle);
            }
            if(notBeenVisited.getSouth()!=null)
            {
                castle = recurseOn(notBeenVisited.getSouth(),castle);
            }
            if(notBeenVisited.getWest()!=null)
            {
                castle = recurseOn(notBeenVisited.getWest(),castle);
            }
            if(notBeenVisited.getEast()!=null)
            {
                castle = recurseOn(notBeenVisited.getEast(),castle);
            }
            int tempNumBeenVisited = totalVisited(castle);
            rooms.add(tempNumBeenVisited-numBeenVisited);
            numBeenVisited = tempNumBeenVisited;
        }
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static Square[][] recurseOn(Square cur, Square[][] curCastle)
    {
        return curCastle;
    }
    
    public static int totalVisited(Square[][] castle)
    {
        int total = 0;
        for(int i = 0; i < castle.length; i++)
        {
            for(int j = 0; j < castle[i].length; j++)
            {
                if(castle[i][j].hasBeenVisited())
                    total++;
            }
        }
        return total;
    }
    
    public static Square getOneVisited(Square[][] castle)
    {
        for(int i = 0; i < castle.length; i++)
        {
            for(int j = 0; j < castle[i].length; j++)
            {
                if(castle[i][j].hasBeenVisited())
                    return castle[i][j];
            }
        }
        return null;
    }
}
