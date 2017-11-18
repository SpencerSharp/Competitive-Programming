import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class C
{
    public static void main(String[] args) throws IOException
    {
       // BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        Scanner s = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        int cases = s.nextInt();
        for(int i = 0; i < cases; i++){
            int lines = s.nextInt();
            for(int j = 0; j < lines; j++){
                int[][] maze = new int[lines][lines];
                String input = s.next();
                for(int k = 0; k < input.length(); k++){
                    String row = input.substring(k,k+1);
                    maze[j][k] = Integer.parseInt(row);
                }
                
                //find the best color and change values to color
                int[] colors = new int[6];
                int moves = 0;
                while(!isSameColor(maze)){
                    int color = bestColor(maze);
                    colors[i-1]++;
                    moves++;
                    ArrayList<Integer[]> nbrs = getNbrs(maze);
                    for(Integer[] nbr : nbrs){
                        int r = nbr[0];
                        int c = nbr[1];
                        maze[r][c] = color;
                      
                    }
                }
                out.println(moves);
                for(int k = 0; k < colors.length; k++){
                    out.print(colors[k] + " ");
                }
                out.println("");
      
            }
        }
        
        //Code here
        
        
        
        
        
        //Code here

        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static ArrayList<Integer[]> getNbrs(int[][] arr){
        Integer[] start = {0,0};
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[0][0] = true;
        ArrayList<Integer[]> nbrsToCheck = new ArrayList<Integer[]>();
        nbrsToCheck.add(start);
        int totNbrs = 0;
        while(nbrsToCheck.size()!=0){
            for(int i = 0; i < nbrsToCheck.size(); i++){
                Integer[] index = nbrsToCheck.get(i);
                int r = index[0], c = index[1];
                if(visited[r][c])
                    continue;
                visited[r][c] = true;
                nbrsToCheck.remove(index);
                nbrsToCheck.add(index);
            }
        }
        return nbrsToCheck;
    }
    
    
    
    
    //propogate outwards from top left index and count up number of neigbors
    //with same color
    public static int bestColor(int[][] arr){
        Integer[] start = {0,0};
        //count up num neighbors
        int[] neighborsAtColors = new int[6];
        for(int i = 1; i < neighborsAtColors.length+1; i++){
            boolean[][] visited = new boolean[arr.length][arr[0].length];
            visited[0][0] = true;
            ArrayList<Integer[]> nbrsToCheck = new ArrayList<Integer[]>();
            nbrsToCheck.add(start);
            int totNbrs = 0;
            while(nbrsToCheck.size()!=0){
                for(int j = 0; j < nbrsToCheck.size(); j++){
                    Integer[] index = nbrsToCheck.get(j);
                    int r = index[0], c = index[1];
                    if(visited[r][c])
                        continue;
                    visited[r][c] = true;
                    totNbrs += numNeighborsWithColor(arr,index,i);
                    nbrsToCheck.remove(index);
                    nbrsToCheck.add(index);
                }
            }
            neighborsAtColors[i-1] = totNbrs;
        }
        
        int max = neighborsAtColors[0];
        int color = 0;
        for(int i = 1; i < neighborsAtColors.length; i++){
            if(neighborsAtColors[i]>max){
                max = neighborsAtColors[i];
                color = i;
            }
        }
        
        return color;
    }
    
    public static int numNeighborsWithColor(int[][] arr, Integer[] startingIndex, int color){
        int r = startingIndex[0];
        int c = startingIndex[1];
        int left, top, bottom, right;
        left = top = bottom = right = 0;
        int nbrs = 0;
        //top
        if(r!=0){
           if(arr[r-1][c] == color){
               nbrs++;
           } 
        }
        //left
        if(c!=0){
            if(arr[r][c-1] == color){
               nbrs++;
           } 
        }
        //bottom
        if(r!=arr[0].length){
            if(arr[r+1][c] == color){
               nbrs++;
           } 
        }
        //right
        if(c!=arr.length){
            if(arr[r][c+1] == color){
               nbrs++;
           } 
        }
        
        return nbrs;
    }
    
    public static boolean isSameColor(int[][] arr){
    int lastVal = arr[0][0];
    for(int i = 1; i < arr.length; i++){
        for(int j = 1; j < arr[i].length; j++){
            if(arr[i][j] != lastVal) 
                return false;
        }
    }
    return true;
    }
}