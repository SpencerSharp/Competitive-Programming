
import static java.lang.System.out;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class Animal {
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
            out.println("ANIMAL");
        }
        
        public int getAge()
        {
            return age;
        }
        
        public String toString(){
            return "Age: " + age;
        }
}
