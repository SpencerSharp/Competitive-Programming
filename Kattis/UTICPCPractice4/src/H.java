import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class H
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        //StringTokenizer st = new StringTokenizer(f.readLine());
        String output = ""; //Write all output to this string
        String wp = f.readLine();
        //st = new StringTokenizer(f.readLine());
        String bp = f.readLine();//st.nextToken();
        //Code here
        //out.println(wp);
        wp = wp.substring(7);
        bp = bp.substring(7);
        String[] wpi = wp.split(",");
        String[] bpi = bp.split(",");
        String[][] board = new String[8][8];
        for(int i = 0; i < wpi.length; i++){
            if(wpi[i].length()==2){
                
                int r = Integer.parseInt(wpi[i].substring(1,2))-1;
                r=7-r;
                int c = wpi[i].charAt(0)-'a';
                board[r][c] = "P";
            }
            else{
                int r = Integer.parseInt(wpi[i].substring(2,3))-1;
                r=7-r;
                int c = wpi[i].charAt(1)-'a';
                //c = 7-c;
                board[r][c] = wpi[i].substring(0,1);
            }
        }
        
        for(int i = 0; i < bpi.length; i++){
            if(bpi[i].length()==2){
                
                int r = Integer.parseInt(bpi[i].substring(1,2))-1;
                r=7-r;
                int c = bpi[i].charAt(0)-'a';
                board[r][c] = "p";
            }
            else{
                int r = Integer.parseInt(bpi[i].substring(2,3))-1;
                r=7-r;
                int c = bpi[i].charAt(1)-'a';
                //c = 7-c;
                board[r][c] = bpi[i].substring(0,1).toLowerCase();
            }
        }
        
        
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[r].length; c++)
            {
                if(board[r][c] == null)
                {
                    board[r][c] = "";
                }
            }
        }
        
        
        boolean white = true;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                String p = (white)? "." : ":";
                if(white){
                    if(board[r][c].equals("")){
                        board[r][c] = p+p+p;
                    }else{
                        board[r][c] = p+board[r][c]+p;
                    }
                }else{ //is black
                    if(board[r][c].equals("")){
                        board[r][c] = p+p+p;
                    }else{
                        board[r][c] = p+board[r][c]+p;
                    }
                }
                white = !white;
            }
            white = !white;
        }
        
        String line = "+---+---+---+---+---+---+---+---+";
        out.println(line);
        for(int r = 0; r < board.length; r++){
            out.print("|");
            for(int c = 0; c < board[r].length; c++){
               out.print(board[r][c]+"|");
            }
            out.println();
            out.println(line);
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