
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
public class Speed {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("speed.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            int num = sc.nextInt();
            double distance = num / 5.0;
            System.out.println(distance);
        }
    }
}
