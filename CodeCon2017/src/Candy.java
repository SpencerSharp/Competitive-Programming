import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Candy
{
    static House start;
    static House end;
    
    static HashMap<String,House> houseFromXYString = new HashMap<String,House>();
    
    public static class House implements Comparable<House>
    {
        int r;
        int c;
        int candy;
        int stepsToReach;
        int maxCandyAtHouse;
        boolean visited = false;
        
        public House(int x, int y, int candy)
        {
            this.r = x;
            this.c = y;
            this.candy = candy;
        }
        
        public int distToEnd()
        {
            return Math.abs(r - end.r) + Math.abs(c - end.c);
        }
        
        public int compareTo(House o)
        {
            return maxCandyAtHouse - o.maxCandyAtHouse;
        }
        
        public boolean equals(Object o)
        {
            return r == ((House)o).r && c == ((House)o).c;
        }
    }
            
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        
        PriorityQueue<House> housesToVisit = new PriorityQueue<House>(Comparator.reverseOrder());
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(st.nextToken());
        
        int max = Integer.parseInt(st.nextToken());
        
        int startX = Integer.parseInt(st.nextToken());
        
        int startY = Integer.parseInt(st.nextToken());
        
        int endX = Integer.parseInt(st.nextToken());
        
        int endY = Integer.parseInt(st.nextToken());
        
        int[][] vals = new int[n][m];
        
        for(int r = 0; r < n; r++)
        {
            st = new StringTokenizer(f.readLine());
            for(int c = 0; c < m; c++)
            {
                vals[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        start = new House(startX, startY, vals[startX][startY]);
        start.maxCandyAtHouse = start.candy;
        
        end = new House(endX, endY, vals[endX][endY]);
        
        housesToVisit.add(start);
        
        while(housesToVisit.size() > 0)
        {
            House cur = housesToVisit.poll();
            
            if(cur.equals(end))
            {
                if(cur.stepsToReach == max)
                {
                    output = "" + cur.maxCandyAtHouse;
                    break;
                }
            }
            
            //Below
            String below = (cur.r + 1) + " " + cur.c;
            if(cur.r + 1 < n)
            {
                House temp = houseFromXYString.get(below);
                int tempMaxCandy = cur.maxCandyAtHouse + temp.candy;
                if(tempMaxCandy > temp.maxCandyAtHouse)
                {
                    
                }
                //if(temp)
                //housesToVisit.add();
            }
            
            //Above
            String above = (cur.r - 1) + " " + cur.c;
            if(cur.r - 1 >= 0)
            {
                
            }
            
            //Left
            String left = cur.r + " " + (cur.c - 1);
            if(cur.c - 1 >= 0)
            {
                
            }
            
            //Right
            String right = cur.r + " " + (cur.c + 1);
            if(cur.c + 1 < m)
            {
                
            }
        }
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
}