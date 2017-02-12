import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;
import java.math.BigInteger;

public class rooks {
    public static void main(String[] args) throws IOException {
        String fileName = "rooks.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        for (int i = 0; i < numLoops; i++) {
            BigInteger cur = new BigInteger(sc.next());
            out.println(getFact(cur));
        }
    }
    
    public static BigInteger getFact(BigInteger cur)
    {
        if(cur.equals(new BigInteger("1")))
            return new BigInteger("1");
        return cur.multiply(getFact(cur.subtract(new BigInteger("1"))));
    }
}
