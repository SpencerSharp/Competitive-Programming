public class Dot implements Locatable
{
    public int x;
    public int y;
    public int size;
    public Dot()
    {
        x = 0;
        y = 0;
        size = 0;
    }
    
    public Dot(int setX, int setY)
    {
        x = setX;
        y = setY;
        size = 0;
    }
    
    public Dot(int setX, int setY, int setSize)
    {
        x = setX;
        y = setY;
        size = setSize;
    }
    
    public int getXPos()
    {
        return x;
    }
    
    public int getYPos()
    {
        return y;
    }
    
    public String toString()
    {
        return x + " " + y + " " + size;
    }
}