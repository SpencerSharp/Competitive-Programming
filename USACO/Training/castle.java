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
        
        public Square(int nY, int nX)
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
        
        public void setVisited()
        {
            visited = true;
        }
        
        public void setNotVisited()
        {
            visited = false;
        }
        
        public boolean hasBeenVisited()
        {
            return visited;
        }
        
        public String toString()
        {
            return x + " " + y;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        //PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        
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
                
                //out.println(num + " " +j + " " + i + " " + binaryRep);
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
                    //out.println(j + " " + i);
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
        Square yeah = castle[0][0];
        //out.println(yeah.getNorth());
        //out.println(yeah.getSouth());
        //out.println(yeah.getWest());
        //out.println(yeah.getEast());
        while(numBeenVisited < x*y)
        {
            //out.println(rooms);
            Square notBeenVisited = getOneNotVisited(castle);
            //out.println(notBeenVisited);
            castle[notBeenVisited.y][notBeenVisited.x].setVisited();
            if(notBeenVisited.getNorth()!=null)
            {
                //out.println("north");
                castle = recurseOn(notBeenVisited.getNorth(),castle);
            }
            if(notBeenVisited.getSouth()!=null)
            {
                //out.println("south");
                castle = recurseOn(notBeenVisited.getSouth(),castle);
            }
            if(notBeenVisited.getWest()!=null)
            {
                //out.println("west");
                castle = recurseOn(notBeenVisited.getWest(),castle);
            }
            if(notBeenVisited.getEast()!=null)
            {
                //out.println("east");
                //out.println(notBeenVisited.getEast());
                castle = recurseOn(notBeenVisited.getEast(),castle);
            }
            int tempNumBeenVisited = totalVisited(castle);
            rooms.add(tempNumBeenVisited-numBeenVisited);
            numBeenVisited = tempNumBeenVisited;
        }
        writer.println(rooms.size());
        int max = 0;
        for(int n : rooms)
            if(n > max)
                max = n;
        writer.println(max);
        //out.println(totalVisited(castle));
        int maxNewRoomSize = 0;
        int maxNewRoomX = 0;
        int maxNewRoomY = 0;
        char maxNewRoomWallRemoved = 0;
        for(int r = 0; r < y; r++)
        {
            for(int c = 0; c < x; c++)
            {
                castle = setAllNotVisited(castle);
                //out.println("tV " +totalVisited(castle));
                Square cur = castle[r][c];
                if(cur.getNorth()==null)
                {
                    if(cur.y!=0)
                    {
                        Square[][] newCastle = copy(castle);
                        newCastle[r][c].addNorth(castle[r-1][c]);
                        newCastle[r-1][c].addSouth(castle[r][c]);
                        newCastle = recurseOn(newCastle[r][c],newCastle);
                        int roomSize = totalVisited(newCastle);
                        if(roomSize > maxNewRoomSize)
                        {
                            maxNewRoomSize = roomSize;
                            maxNewRoomX = c+1;
                            maxNewRoomY = r+1;
                            maxNewRoomWallRemoved = 'N';
                        }
                        else if(roomSize == maxNewRoomSize)
                        {
                            if(c+1 < maxNewRoomX)
                            {
                                maxNewRoomSize = roomSize;
                                maxNewRoomX = c+1;
                                maxNewRoomY = r+1;
                                maxNewRoomWallRemoved = 'N';
                            }
                            else if(c + 1 == maxNewRoomX)
                            {
                                if(r+1 >= maxNewRoomY)
                                {
                                    maxNewRoomSize = roomSize;
                                    maxNewRoomX = c+1;
                                    maxNewRoomY = r+1;
                                    maxNewRoomWallRemoved = 'N';
                                }
                            }
                        }
                    }
                }
                if(cur.getEast()==null)
                {
                    if(cur.x!=castle[0].length-1)
                    {
                        Square[][] newCastle = copy(castle);
                        newCastle[r][c].addEast(castle[r][c+1]);
                        newCastle[r][c+1].addWest(castle[r][c]);
                        
                        //out.println("should be null "+newCastle[r][c]+" "+newCastle[r][c].getEast());
                        //out.println("should be null "+newCastle[r][c+1]+" "+newCastle[r][c+1].getWest());
                        newCastle = recurseOn(newCastle[r][c],newCastle);
                        int roomSize = totalVisited(newCastle);
                        if(roomSize > maxNewRoomSize)
                        {
                            maxNewRoomSize = roomSize;
                            maxNewRoomX = c+1;
                            maxNewRoomY = r+1;
                            maxNewRoomWallRemoved = 'E';
                        }
                        else if(roomSize == maxNewRoomSize)
                        {
                            if(c+1 < maxNewRoomX)
                            {
                                maxNewRoomSize = roomSize;
                                maxNewRoomX = c+1;
                                maxNewRoomY = r+1;
                                maxNewRoomWallRemoved = 'E';
                            }
                            else if(c + 1 == maxNewRoomX)
                            {
                                if(r+1 > maxNewRoomY)
                                {
                                    maxNewRoomSize = roomSize;
                                    maxNewRoomX = c+1;
                                    maxNewRoomY = r+1;
                                    maxNewRoomWallRemoved = 'E';
                                }
                            }
                        }
                        //out.println((r+1) + " " + (c+1) + " "+totalVisited(newCastle));
                    }
                }
                /*if(cur.getWest()==null)
                {
                    if(cur.x!=0)
                    {
                        Square[][] newCastle = copy(castle);
                        newCastle[r][c].addWest(castle[r][c-1]);
                        newCastle[r][c-1].addEast(castle[r][c]);
                        newCastle = recurseOn(newCastle[r][c],newCastle);
                        int roomSize = totalVisited(newCastle);
                        if(roomSize >= maxNewRoomSize)
                        {
                            maxNewRoomSize = roomSize;
                            maxNewRoomX = c+1;
                            maxNewRoomY = r+1;
                            maxNewRoomWallRemoved = 'W';
                        }
                    }
                }*/
                /*if(cur.getSouth()==null)
                {
                    if(cur.y!=castle.length-1)
                    {
                        Square[][] newCastle = copy(castle);
                        newCastle[r][c].addSouth(castle[r+1][c]);
                        newCastle[r+1][c].addNorth(castle[r][c]);
                        newCastle = recurseOn(newCastle[r][c],newCastle);
                        int roomSize = totalVisited(newCastle);
                        if(roomSize >= maxNewRoomSize)
                        {
                            if(c+1 == maxNewRoomX)
                            {
                                if(r+1==maxNewRoomY)
                                {
                                    if()
                                }
                            }
                            maxNewRoomSize = roomSize;
                            maxNewRoomX = c+1;
                            maxNewRoomY = r+1;
                            maxNewRoomWallRemoved = 'S';
                        }
                    }
                }*/
            }
        }
        writer.println(maxNewRoomSize);
        writer.println(maxNewRoomY + " " + maxNewRoomX + " " + maxNewRoomWallRemoved);
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
        
    }
    
    public static Square[][] copy(Square[][] castle)
    {
        Square[][] newCastle = new Square[castle.length][castle[0].length];
        for(int r = 0; r < castle.length; r++)
        {
            for(int c = 0; c < castle[r].length; c++)
            {
                Square cur = castle[r][c];
                newCastle[r][c] = new Square(cur.y,cur.x);
                if(cur.getNorth()!=null)
                    newCastle[r][c].addNorth(cur.getNorth());
                if(cur.getEast()!=null)
                    newCastle[r][c].addEast(cur.getEast());
                if(cur.getWest()!=null)
                    newCastle[r][c].addWest(cur.getWest());
                if(cur.getSouth()!=null)
                    newCastle[r][c].addSouth(cur.getSouth());
            }   
        }
        return newCastle;
    }
    
    public static Square[][] setAllNotVisited(Square[][] castle)
    {
        for(int r = 0; r < castle.length; r++)
        {
            for(int c = 0; c < castle[r].length; c++)
            {
                castle[r][c].setNotVisited();
            }   
        }
        return castle;
    }
    
    public static Square[][] recurseOn(Square cur, Square[][] curCastle)
    {
        //out.println(cur);
        if(cur.hasBeenVisited())
            return curCastle;
        //out.println("not visited");
        curCastle[cur.y][cur.x].setVisited();
        if(cur.getNorth()!=null)
        {
            //out.println("north");
            curCastle = recurseOn(curCastle[cur.getNorth().y][cur.getNorth().x],curCastle);
        }
        if(cur.getWest()!=null)
        {
            //out.println("west");
            curCastle = recurseOn(curCastle[cur.getWest().y][cur.getWest().x],curCastle);
        }
        if(cur.getEast()!=null)
        {
            //out.println("east");
            curCastle = recurseOn(curCastle[cur.getEast().y][cur.getEast().x],curCastle);
        }
        if(cur.getSouth()!=null)
        {
            //out.println("south");
            curCastle = recurseOn(curCastle[cur.getSouth().y][cur.getSouth().x],curCastle);
        }
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
    
    public static Square getOneNotVisited(Square[][] castle)
    {
        for(int i = 0; i < castle.length; i++)
        {
            for(int j = 0; j < castle[i].length; j++)
            {
                if(!castle[i][j].hasBeenVisited())
                    return castle[i][j];
            }
        }
        return null;
    }
}