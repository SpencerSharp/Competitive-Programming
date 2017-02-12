import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class who {
    public static void main(String[] args) throws IOException {
        String fileName = "who.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        for (int n = 0; n < numLoops; n++) {
            String name = sc.next();
            name = name.toUpperCase();
            String gender = "male";
            String g = sc.next();
            if (g.equals("F"))
                gender = "female";
            String hair = "";
            String h = sc.next();
            if (h.equals("W"))
                hair = "white hair";
            else if (h.equals("BR"))
                hair = "brown hair";
            else if (h.equals("BL"))
                hair = "blonde hair";
            else if (h.equals("BLK"))
                hair = "black hair";
            else if (h.equals("R"))
                hair = "red hair";
            String e = sc.next();
            String eyes = "";
            if (e.equals("BL"))
                eyes = "blue eyes";
            else if (e.equals("BR"))
                eyes = "brown eyes";
            else if (e.equals("G"))
                eyes = "green eyes";
            
            String glasses = "glasses";
            if (sc.next().equals("N"))
                glasses = "no glasses";
            
            String hats = "hat";
            if (sc.next().equals("N"))
                hats = "no hat";
            
            int size = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < size; i++) {
                String query = sc.nextLine();
                //query = query.toUpperCase();
                if (query.toUpperCase().contains(name) || query.contains(gender) || query.contains(hair) || query.contains(eyes) || query.contains(glasses) || query.contains(hats))
                    out.println("yes");
                else
                    out.println("no");
            }
            
        }
    }
    
}
