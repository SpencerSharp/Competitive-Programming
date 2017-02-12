import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bo
 */
public class MalFunction {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("malfunction.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            int co1 = sc.nextInt();
            int co2 = sc.nextInt();
            int co3 = sc.nextInt();
            double x = Double.parseDouble(sc.next());
            out.printf("%.3f\n",(co1*x*x)+(co2*x)+co3);
        }
    }
}
