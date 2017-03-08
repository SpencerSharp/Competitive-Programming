
import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob06 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("prob06-1-in.txt"));
        int size = file.nextInt();
        file.nextLine();
        for(int i = 0; i < size; i++) {
            String givenSequence = file.nextLine();
            String[] givenSequenceArray = givenSequence.split(" ");
            int length = givenSequenceArray.length - 1;
            int[] givenSequenceArrayInt = new int[length];
            for(int k = 1; k < length + 1; k++) {
                givenSequenceArrayInt[k - 1] = Integer.parseInt(givenSequenceArray[k]);
            }
            int[] deltaArray = new int[length - 1];
            for(int k = 0; k < length - 1; k++) {
                deltaArray[k] = givenSequenceArrayInt[k + 1] - givenSequenceArrayInt[k];
            }
            int[] reversed = new int[length];
            reversed[0] = givenSequenceArrayInt[0];
            for(int k = 1; k < length; k++) {
                reversed[k] = reversed[k - 1] + (deltaArray[k - 1] * -1);
            }
            String output = "";
            for(int k = 0; k < length - 1; k++) {
                output += reversed[k] + " ";
            }
            
            output+= reversed[length - 1];
            out.println(output);
            
            
        }
        
        String toFix = "I locate Max McMillion";
        toFix = toFix.toUpperCase();
        toFix = fixString(toFix);
        out.println(toFix);
    }

}