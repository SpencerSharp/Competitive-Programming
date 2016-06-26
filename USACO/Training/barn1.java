/*
ID: spencer16
LANG: JAVA
PROG: barn1
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class barn1
{
    public static class Board
    {
        int startSpot;
        int endSpot;
        
        public Board()
        {
            
        }
        
        public Board(int s, int e)
        {
            startSpot = s;
            endSpot = e;
        }
        
        public int getStartSpot()
        {
            return startSpot;
        }
        
        public void setStartSpot(int s)
        {
            startSpot = s;
        }
        
        public int getEndSpot()
        {
            return endSpot;
        }
        
        public void setEndSpot(int e)
        {
            endSpot = e;
        }
        
        public boolean doesBoardOff(int spot)
        {
            if(spot >= startSpot && spot <= endSpot)
                return true;
            return false;
        }
        
        public int getSize()
        {
            return endSpot-startSpot+1;
        }
        
        public ArrayList<Board> splitBoard(int startOfSplit, int endOfSplit)
        {
            Board b1 = new Board(startSpot,startOfSplit);
            Board b2 = new Board(endOfSplit,endSpot);
            ArrayList<Board> boards = new ArrayList<Board>();
            //ArrayList<Board> boards = new ArrayList<Board>();
            boards.add(b1);
            boards.add(b2);
            return boards;
        }
        
        public String toString()
        {
            return startSpot + "-" + endSpot;
        }
    }

    public static int getMin(ArrayList<Integer> ray)
    {
        int min = ray.get(0);
        for(int n : ray)
            if(n < min)
                min = n;
        return min;
    }

    public static int getMax(ArrayList<Integer> ray)
    {
        int max = ray.get(0);
        for(int n : ray)
            if(n>max)
                max = n;
        return max;
    }
    
    public static boolean contains(ArrayList<Integer> cows, int number)
    {
        for(int n : cows)
        {
            if(n==number)
                return true;
        }
        return false;
    }

    public static ArrayList<Integer> getBestSplit(ArrayList<Integer> cows, ArrayList<Board> boards)
    {
        //ArrayList<Integer> bestSplits = new ArrayList<Integer>();
        int index = 0;
        int splitStart = boards.get(0).getStartSpot()+1;
        int splitEnd = boards.get(0).getEndSpot()-1;
        int maxStallsSaved = 0;
        int spot = 0;
        for(Board b : boards)
        {
            for(int i = b.getStartSpot(); i < b.getEndSpot(); i++)
            {
                for(int j = i+1; j <= b.getEndSpot(); j++)
                {
                    int stallsSaved = 0;
                    boolean valid = true;
                    for(int n = i+1; n < j; n++)
                    {
                        if(!contains(cows,n))
                        {
                            stallsSaved++;
                        }
                        else
                        {
                            valid = false;
                            break;
                        }
                    }
                    //if(i==4)
                        //out.println(j+""+valid);
                    if(valid&&maxStallsSaved<stallsSaved)
                    {
                        splitStart = i;
                        splitEnd = j;
                        index = spot;
                        maxStallsSaved = stallsSaved;
                        //out.println(index + " " + splitStart + " " + splitEnd);
                    }
                }
            }
            spot++;
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(index);
        ret.add(splitStart);
        ret.add(splitEnd);
        //out.println(ret);
        return ret;
    }

    public static ArrayList<Board> getBestBoards(ArrayList<Integer> s, int maxBoards)
    {
        ArrayList<Board> boards = new ArrayList<Board>();
        Board b1 = new Board(getMin(s),getMax(s));
        boards.add(b1);
        for(int i = 1; i < maxBoards; i++)
        {
            ArrayList<Integer> split = getBestSplit(s,boards);
            int boardToSplit = split.get(0);
            int startSplit = split.get(1);
            int endSplit = split.get(2);
            ArrayList<Board> splitBoards = boards.get(boardToSplit).splitBoard(startSplit, endSplit);
            boards.remove(boardToSplit);
            boards.addAll(splitBoards);
            //out.println(boards);
        }
        return boards;
    }
    
    /*
    public static boolean allBoarded(ArrayList<Integer> spotsOccupied, ArrayList<Board> boards)
    {
        
        for(int n : spotsOccupied)
        {
            boolean isBoarded = false;
            for(Board b : boards)
            {
                if(b.doesBoardOff(n))
                {
                    
                }
            }
        }
        
    }
    */

    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        ArrayList<Integer> spotsOccupied = new ArrayList<Integer>();
        
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int maxBoards = Integer.parseInt(st.nextToken());
        st.nextToken();
        int numCows = Integer.parseInt(st.nextToken());
        for(int i = 0; i < numCows; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            spotsOccupied.add(Integer.parseInt(st.nextToken()));
        }
        //out.println(spotsOccupied);
        //Collections.sort(spotsOccupied);
        ArrayList<Board> boards = getBestBoards(spotsOccupied,maxBoards);
        int totalBlocked = 0;
        for(Board b : boards)
        {
            totalBlocked += b.getSize();
            //out.println(b);
        }
        //totalBlocked += numCows;
        output += totalBlocked;
        if(maxBoards>numCows)
            output = ""+numCows;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}