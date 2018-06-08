
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ship
{
    int size;
    double cost;
    int ammo;
    
    public Ship(int s, double c, int a)
    {
        size = s;
        cost = c;
        ammo = a;
    }
    
    public void addAmmo(int y)
    {
        ammo += y;
    }
    
    public void shoot(int g)
    {
        ammo -=g;
    }
    
    public void battle(int num)
    {
        while(num>0&&ammo>0){
            ammo--;
            num--;
        }
        if(num>ammo){
            System.out.print("ENEMIES WIN ");
        }
        else{
            System.out.print("YOU WIN ");
        }
    }
    
    public int getAmmo()
    {
        return ammo;
    }
    
    public static int recur(int y)
    {
        if(y<4)
            return(2);
        return recur(y-3)+6;
    }
    
    public static void main(String[] args)
    {
        TreeSet<String> ts = new TreeSet<String>();
        ts.add("dog");
        //System.out.println(ts.(0));
    }
}