import static java.lang.System.*;
public class RadicalSimplification {
    public static void main(String[] args)
    {
        int num = 12;
        int factoredOut = 1;
        int inRad = num;
        for(int i = num; i >= 1; i--)
        {
            if(inRad%(i*i)==0)
            {
                factoredOut *= i;
                inRad /= (i*i);
            }
        }
        if(factoredOut==1)
        {
            out.println("rad " +inRad);
        }
        else
        {
            out.println(factoredOut + " rad " + inRad);
        }
    }
}
