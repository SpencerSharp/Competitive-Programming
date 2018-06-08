import static java.lang.System.*;

public class TestANgles {
    public static double offset = 155.4;
    public static void main(String[] args)
    {
        double newTarget = 23;
        out.println(getOffsetAngle(newTarget));
    }
    
    public static double getOffsetAngle(double ang)
    {
        double newAng = ang - offset;
        if(newAng > 180.0)
            newAng -= 360;
        else if(newAng < -180.0)
            newAng += 360;
        return newAng;
    }
}
