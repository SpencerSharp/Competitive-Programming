/*
ID: spencer16
LANG: JAVA
PROG: combo
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class combo
{
    public static class Combo
    {
        public int size;
        public int n1;
        public int n2;
        public int n3;
        
        public Combo()
        {
            
        }
        
        public Combo(int size, int n1, int n2, int n3)
        {
            this.size = size;
            this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
        }
        
        public ArrayList<Combo> genCloseTo()
        {
            ArrayList<Combo> ret = new ArrayList<Combo>();
            for(int a = -2; a <=2; a++)
            {
                for(int b = -2; b <=2; b++)
                {
                    for(int c = -2; c <=2; c++)
                    {
                        int newN1 = n1+a;
                        if(newN1<1)
                        {
                            if(newN1==0)
                                newN1 = size;
                            else if(size > 1)
                                newN1 = size-1;
                            else
                                newN1 = 1;
                        }
                        if(newN1>size)
                        {
                            if(newN1==size+1)
                                newN1 = 1;
                            else if(size>1)
                                newN1 = 2;
                            else
                                newN1 = 1;
                        }
                        
                        int newN2 = n2+b;
                        if(newN2<1)
                        {
                            if(newN2==0)
                                newN2 = size;
                            else if(size > 1)
                                newN2 = size-1;
                            else
                                newN2 = 1;
                        }
                        if(newN2>size)
                        {
                            if(newN2==size+1)
                                newN2 = 1;
                            else if(size>1)
                                newN2 = 2;
                            else
                                newN2 = 1;
                        }
                        
                        int newN3 = n3+c;
                        if(newN3<1)
                        {
                            if(newN3==0)
                                newN3 = size;
                            else if(size > 1)
                                newN3 = size-1;
                            else
                                newN3 = 1;
                        }
                        if(newN3>size)
                        {
                            if(newN3==size+1)
                                newN3 = 1;
                            else if(size>1)
                                newN3 = 2;
                            else
                                newN3 = 1;
                        }
                        
                        Combo add = new Combo(size,newN1,newN2,newN3);
                        ret.add(add);
                    }
                }
            }
            return ret;
        }
        
        public boolean equals(Combo c)
        {
            if(size!=c.getSize())
                return false;
            if(n1!=c.getn1())
                return false;
            if(n2!=c.getn2())
                return false;
            if(n3!=c.getn3())
                return false;
            return true;
        }
        
        public int getSize()
        {
            return size;
        }
        
        public int getn1()
        {
            return n1;
        }
        
        public int getn2()
        {
            return n2;
        }
        
        public int getn3()
        {
            return n3;
        }
    }
    
    public static ArrayList<Combo> addAllNoRepeats(ArrayList<Combo> start, ArrayList<Combo> adding)
    {
        for(Combo c1 : adding)
        {
            boolean found = false;
            for(Combo c : start)
                if(c.equals(c1))
                {
                    found = true;
                    break;
                }
            if(!found)
                start.add(c1);
        }
        return start;
    }

    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int size = Integer.parseInt(f.readLine());
        String line1 = f.readLine();
        StringTokenizer st = new StringTokenizer(line1);
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());
        Combo combo1 = new Combo(size,n1,n2,n3);
        ArrayList<Combo> comboes1 = combo1.genCloseTo();
        
        String line2 = f.readLine();
        st = new StringTokenizer(line2);
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        n3 = Integer.parseInt(st.nextToken());
        Combo combo2 = new Combo(size,n1,n2,n3);
        ArrayList<Combo> comboes2 = combo2.genCloseTo();
        
        ArrayList<Combo> finalComboes = new ArrayList<Combo>();
        finalComboes = addAllNoRepeats(finalComboes, comboes1);
        finalComboes = addAllNoRepeats(finalComboes, comboes2);
        
        int result = finalComboes.size();
        output += result;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
    }
}
