import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF60B
{
    static int k;
    static int n;
    static int m;
    
    public static class Spot
    {
        int layer;
        int row;
        int col;
        boolean visited = false;
        
        public Spot()
        {
            
        }
        
        public Spot(int layer, int row, int col)
        {
            this.layer = layer;
            this.row = row;
            this.col = col;
        }
        
        public HashSet<String> getKeysForChildren()
        {
            HashSet<String> ret = new HashSet<String>();
            if(layer > 0)
            {
                ret.add((layer-1) + " " + row + " " + col);
            }
            if(layer < k-1)
            {
                ret.add((layer+1) + " " + row + " " + col);
            }
            if(row > 0)
            {
                ret.add(layer + " " + (row-1) + " " + col);
            }
            if(row < n-1)
            {
                ret.add(layer + " " + (row+1) + " " + col);
            }
            if(col > 0)
            {
                ret.add(layer + " " + row + " " + (col-1));
            }
            if(col < m-1)
            {
                ret.add(layer + " " + row + " " + (col+1));
            }
            return ret;
        }
        
        public void setVisited(boolean b)
        {
            visited = b;
        }
        
        public boolean visited()
        {
            return visited;
        }
        
        public String toString()
        {
            return layer + " " + row + " " + col;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f.readLine();
        
        int numDots = 0;
        
        HashMap<String,Spot> spots = new HashMap<String,Spot>();
        
        for(int curK = 0; curK < k; curK++)
        {
            for(int i = 0; i < n; i++)
            {
                
                String line = f.readLine();
                for(int j = 0; j < m; j++)
                {
                    char c = line.charAt(j);
                    if(c=='.')
                    {
                        Spot s = new Spot(curK, i, j);
                        spots.put(s.toString(), s);
                        numDots++;
                    }
                }
            }
            f.readLine();
        }
        
        //out.println(spots);
        
        //out.println(numDots);
        
        st = new StringTokenizer(f.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        Spot cur = spots.get("0 " + (x-1) + " " + (y-1));
        
        Stack<Spot> stack = new Stack<Spot>();
        
        stack.push(cur);
        
        int numConnected = 0;
        
        while(stack.size() > 0)
        {
            cur = stack.pop();
            //out.println(cur);
            if(!cur.visited())
            {
                numConnected++;
                cur.setVisited(true);
                HashSet<String> connected = cur.getKeysForChildren();
                //out.println("CONNECTED " + connected);
                for(String s : connected)
                {
                    Spot temp = spots.get(s);
                    if(temp!=null && !temp.visited())
                        stack.push(spots.get(s));
                }
            }
        }
        
        output = ""+numConnected;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static String disp(char[][][] plate)
    {
        String ret = "";
        for(int curK = 0; curK < plate.length; curK++)
        {
            for(int curN = 0; curN < plate[curK].length; curN++)
            {
                for(int curM = 0; curM < plate[curK][curN].length; curM++)
                {
                    ret += plate[curK][curN][curM];
                }
                ret += "\n";
            }
            ret += "\n";
        }
        return ret;
    }
    
    public static int spread(char[][][] plate, int k, int n, int m, boolean checkAsterisks)
    {
        char setChar;
        int dotsRemoved = 0;
        if(checkAsterisks)
            setChar = '?';
        else
            setChar = '*';
        if(k > 0) //Spread up
        {
            if(plate[k-1][n][m]=='.')
            {
                plate[k-1][n][m] = setChar;
                return 1;
            }
        }
        if(k < plate.length-1)
        {
            if(plate[k+1][n][m]=='.')
            {
                plate[k+1][n][m] = setChar;
                return 1;
            }
        }
        if(n > 0)
        {
            if(plate[k][n-1][m]=='.')
            {
                plate[k][n-1][m] = setChar;
                return 1;
            }
        }
        if(n < plate[0].length-1)
        {
            if(plate[k][n+1][m]=='.')
            {
                plate[k][n+1][m] = setChar;
                return 1;
            }
        }
        if(m > 0)
        {
            if(plate[k][n][m-1]=='.')
            {
                plate[k][n][m-1] = setChar;
                return 1;
            }
        }
        if(m < plate[0][0].length-1)
        {
            if(plate[k][n][m+1]=='.')
            {
                plate[k][n][m+1] = setChar;
                return 1;
            }
        }
        return dotsRemoved;
    }
}