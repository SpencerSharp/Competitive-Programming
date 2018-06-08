
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
public class Mammal extends Animal{
    private String species;
    public int age;
    
    public Mammal(String s, int a)
    {
        age = a;
        species = s;
        out.println("HELLO");
    }
    
    public String getSpecies()
    {
        return "species";
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int b)
    {
        age = b;
        //out.println("MAMMAL");
    }
    
    public void setAge()
    {
        age = 20;
    }
    
    public String toString()
    {
        return "Age: " + this.getAge() + " Species: " + species;
    }

    public static void main(String[] args)
    {
        //Animal animal = new Animal();
        //animal.setAge(15);
        //out.println(animal);
        Animal dog = new Mammal("dog",15);
        Mammal dog2 = new Mammal("dog",15);
        out.println(dog.age);
        out.println(dog2.age);
        out.println(dog);
        out.println(dog2);
        //dog.setAge(10);
        //out.println(dog.getAge());
        //Mammal cat = new Mammal("cat",500);
        //cat.setAge(10);
        //out.println(cat);
    }
}
