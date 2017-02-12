
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
public class Taxing {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("taxing.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            double price = sc.nextDouble();
            price *= 1.0825;
            System.out.print("$");
            System.out.printf("%.2f", price);
            System.out.println();
        }
    }
}
