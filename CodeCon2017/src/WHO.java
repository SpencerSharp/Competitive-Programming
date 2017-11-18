import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class WHO
{
    static HashMap<Cell,Cell> cells = new HashMap<Cell,Cell>();
    static HashSet<Region> regions = new HashSet<Region>();
    
    public static class Cell
    {
        int x;
        int y;
        int val; //0 == safe, 1 == contaminated, 2 == walled
        HashSet<Cell> neighbors = new HashSet<Cell>();
        
        public Cell(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        
        public Cell(int x, int y, int val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public HashSet<Cell> returnAllContaminatedCellsInRegion(HashSet<Cell> toExclude)
        {
            HashSet<Cell> ret = new HashSet<Cell>();
            
            for(Cell c : neighbors)
            {
                if(c.val == 1)
                    ret.add(c);
            }
            
            toExclude.add(this);
            
            for(Cell c : neighbors)
            {
                if(c.val == 1 && !toExclude.contains(c))
                {
                    ret.addAll(c.returnAllContaminatedCellsInRegion(toExclude));
                }
            }
            return ret;
        }
        
        public HashSet<Cell> nonContaminatedNeighbors()
        {
            HashSet<Cell> ret = new HashSet<Cell>();
            for(Cell c : neighbors)
            {
                if(c.val == 0)
                    ret.add(c);
            }
            return ret;
        }
        
        public void contaminateNeighbors()
        {
            //out.println("BASE: " + toString() + " CONTAMINATING: " + neighbors);
            for(Cell c : neighbors)
            {
                if(c.val == 0)
                {
                    //out.println(c + " CONTAMINATED");
                    c.val = 1;
                }
            }
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 23 * hash + this.x;
            hash = 23 * hash + this.y;
            return hash;
        }
        
        public boolean equals(Object o)
        {
            return x==((Cell)o).x && y == ((Cell)o).y;
        }
        
        public String toString()
        {
            return x + " " + y;
        }
    }
    
    public static class Region
    {
        HashSet<Cell> cells;
        
        public Region(Cell baseCell)
        {
            HashSet<Cell> theCell = new HashSet<Cell>();
            theCell.add(baseCell);
            
            cells = baseCell.returnAllContaminatedCellsInRegion(theCell);
            cells.add(baseCell);
            //out.println("CELLS: " + cells);
        }

        public int numCellsInRegion()
        {
            return cells.size();
        }
        
        public int potential()
        {
            HashSet<Cell> potentials = new HashSet<Cell>();
            for(Cell c : cells)
            {
                potentials.addAll(c.nonContaminatedNeighbors());
            }
            return potentials.size();
        }
        
        public int numWalls()
        {
            int total = 0;
            for(Cell c : cells)
            {
                for(Cell c2 : c.neighbors)
                {
                    if(c2.val == 0)
                        total++;
                }
            }
            return total;
        }
        
        public void wallRegion()
        {
            for(Cell c : cells)
            {
                c.val = 2;
            }
        }
        
        public void expand()
        {
            for(Cell c : cells)
            {
                c.contaminateNeighbors();
            }
            Cell baseCell = null;
            for(Cell c : cells)
            {
                if(baseCell == null)
                {
                    baseCell = c;
                    break;
                }
            }
            
            HashSet<Cell> theCell = new HashSet<Cell>();
            //out.println("THE BASE: " + baseCell);
            cells = baseCell.returnAllContaminatedCellsInRegion(theCell);
            cells.add(baseCell);
        }
        
        public boolean equals(Object other)
        {
            return cells.equals(((Region)other).cells);
        }
        
        public boolean containsCell(Cell c)
        {
            return cells.contains(c);
        }
        
        public String toString()
        {
            return numCellsInRegion()+"";
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
        int maxR = Integer.parseInt(f.readLine());
        int maxC = Integer.parseInt(f.readLine());
        int[][] ray = new int[maxR][maxC];
        String line;
        
        for(int r = 0; r < maxR; r++)
        {
            line = f.readLine();
            for(int c = 0; c < maxC; c++)
            {
                ray[r][c] = line.charAt(c);
                int val = 0;
                if(ray[r][c] == 'C')
                    val = 1;
                Cell cell = new Cell(r,c,val);
                
                cells.put(cell,cell);
            }
        }
        
        for(Cell c : cells.keySet())
        {
            Cell temp = new Cell(c.x, c.y);
            temp.x--;
            if(cells.containsKey(temp))
            {
                
                c.neighbors.add(cells.get(temp));
            }
            temp.x++;
            
            temp.x++;
            if(cells.containsKey(temp))
            {
                //out.println("NEVER");
                c.neighbors.add(cells.get(temp));
            }
            temp.x--;
            
            temp.y++;
            if(cells.containsKey(temp))
            {
                c.neighbors.add(cells.get(temp));
            }
            temp.y--;
            
            temp.y--;
            if(cells.containsKey(temp))
            {
                c.neighbors.add(cells.get(temp));
            }
            temp.y++;
            
            cells.put(c, c);
        }
        
        for(Cell c : cells.keySet())
        {
            if(c.val == 1)
            {
                boolean alreadyInRegion = false;
                for(Region r : regions)
                {
                    if(r.containsCell(c))
                    {
                        alreadyInRegion = true;
                    }
                }
                if(!alreadyInRegion)
                {
                    Region r = new Region(c);
                    regions.add(r);
                }
            }
        }
        
        int walls = 0;
        while(regions.size() > 0)
        {
            
            //out.println(regions);
            Region maxRegion = null;
            int maxPotential = 0;
            
            for(Region r : regions)
            {
                out.println(r.cells);
                int p = r.potential();
                if(maxRegion == null)
                {
                    maxRegion = r;
                    maxPotential = p;
                }
                else if(p > maxRegion.potential())
                {
                    maxRegion = r;
                    maxPotential = p;
                }
            }
            out.println("---");
            
            
            walls += maxRegion.numWalls();
            out.println("WALLS: " + walls);
            regions.remove(maxRegion);
            
            maxRegion.wallRegion();
            
            for(Region r : regions)
            {
                r.expand();
            }
            
            //out.println(regions);
            
            HashSet<Region> newRegions = new HashSet<Region>();
            
            for(Region r : regions)
            {
                newRegions.add(r);
            }
            
            regions = newRegions;
        }
        output = ""+walls;
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
}