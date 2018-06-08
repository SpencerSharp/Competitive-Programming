
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.lang.Math;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class Test {
    public static void main(String[] args)
    {
        int a = Integer.parseInt("c",13);
        double b = Double.NaN;
        a += b * .1;
        b = Double.POSITIVE_INFINITY;
        out.println(b);
        out.println(a);
    }

    public static class Animal{
        public int age;
        public Animal()
        {
            age = 5;
        }
        
        public Animal(int a)
        {
            age = a;
        }
        
        public void setAge(int age)
        {
            age = age;
        }
        
        public int getAge()
        {
            return age;
        }
        
        public String toString(){
            return "Age: " + age;
        }
    }
    public static double r(double x, double y)
    {
        if(x < y)
            return r(x+1.5,y) + x;
        if(y < x)
            return r(x,y+2) + y;
        return x * y;
    }
}
