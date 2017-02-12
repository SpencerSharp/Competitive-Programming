
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bo
 */
public class Touchy {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("touchy.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            int current = sc.nextInt();
            int touch = sc.nextInt();
            current += touch;
            int now = current % 4;
            System.out.println(now);
            
        }
    }
}
