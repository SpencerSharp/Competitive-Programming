import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class rock {
    public static void main(String[] args) throws IOException {
        String fileName = "rock.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        for (int i = 0; i < numLoops; i++) {
            out.println(results(sc.next()));
            if(i<numLoops-1)
                out.println();
        }
    }
    
    public static String results(String moves) {
        int wins = 0;
        int draws = 0;
        int losses = 0;
        char oppMove = 'R';
        
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == oppMove) {
                draws++;
            }
            else if (moves.charAt(i) == 'R' && oppMove == 'P') {
                losses++;
            } else if (moves.charAt(i) == 'R' && oppMove == 'S') {
                wins++;
                oppMove = 'P';
            } else if (moves.charAt(i) == 'P' && oppMove == 'S') {
                losses++;
            } else if (moves.charAt(i) == 'P' && oppMove == 'R') {
                wins++;
                oppMove = 'S';
            } else if (moves.charAt(i) == 'S' && oppMove == 'R') {
                losses++;
            } else if (moves.charAt(i) == 'S' && oppMove == 'P') {
                wins++;
                oppMove = 'R';
            }
           
        }
        return "Wins: " + wins + "\nLosses: " + losses + "\nTies: " + draws;
    }
    
}
