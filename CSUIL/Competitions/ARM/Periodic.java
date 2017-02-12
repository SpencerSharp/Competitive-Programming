
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
public class Periodic {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("periodic.dat"));
        ArrayList<String> elements1 = new ArrayList<String>();
        ArrayList<String> elements2 = new ArrayList<String>();
        String elements = sc.nextLine() + " " + sc.nextLine() + " " + sc.nextLine() + " " + sc.nextLine();
        Scanner elem = new Scanner(elements);
        while (elem.hasNext()) {
            String element = elem.next();
            if (element.length() == 1)
                elements1.add(element.toLowerCase());
            else 
                elements2.add(element.toLowerCase());
        }

        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            String word = sc.next();
            boolean finished = false;
            boolean failed = false;
            while (!finished && !failed) {
                if (elements1.contains(word.substring(0, 1))) {

                    if (word.length() > 1)
                        word = word.substring(1);
                    else {
                        break;
                    }
                }
                else if (word.length() >= 2 && elements2.contains(word.substring(0, 2))) {

                    if (word.length() > 2)
                        word = word.substring(2);
                    else {
                        break;
                    }
                }
                else
                    failed = true;
            }
            
            if (failed)
                System.out.println("no");
            else 
                System.out.println("yes");
        }
    }
}
