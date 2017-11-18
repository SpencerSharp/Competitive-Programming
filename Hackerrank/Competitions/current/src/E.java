import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class E
{
    public static class Student implements Comparable<Student>
    {
        String firstName;
        String lastName;
        int numSiblings;
        int birthMonth;
        int birthDay;
        
        public Student(String f, String l, int n, int bM, int bD)
        {
            firstName = f;
            lastName = l;
            numSiblings = n;
            birthMonth = bM;
            birthDay = bD;
        }
        
        public int compareTo(Student other)
        {
            boolean thisVowel = isVowel(firstName.charAt(0));
            boolean oVowel = isVowel(other.firstName.charAt(0));
            
            if(thisVowel ^ oVowel)
            {
                if(thisVowel)
                    return 1;
                else
                    return -1;
            }
            
            
            if(numSiblings != other.numSiblings)
            {
                if(numSiblings > other.numSiblings)
                    return 1;
                return -1;
            }
            
            if(easyMonth(birthMonth) ^ easyMonth(other.birthMonth))
            {
                if(easyMonth(birthMonth))
                    return 1;
                else
                    return -1;
            }
            
            if(birthDay != other.birthDay)
            {
                if(birthDay < other.birthDay)
                    return 1;
                return -1;
            }
            
            return lastName.compareTo(other.lastName);
        }
        
        public String toString()
        {
            return firstName + " " + lastName;
        }
    }
    
    public static boolean isVowel(char c)
    {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
    
    public static boolean easyMonth(int n)
    {
        if(n == 6 || n == 7 || n == 8)
            return true;
        return false;
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        TreeSet<Student> t = new TreeSet<Student>();
        
        int numStudents = Integer.parseInt(f.readLine());
        
        StringTokenizer st;
        
        for(int i = 0; i < numStudents; i++)
        {
            st = new StringTokenizer(f.readLine());
            
            String n = st.nextToken();
            String l = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Student stu = new Student(n,l,s,m,d);
            t.add(stu);
        }
        
        for(Student stu : t)
        {
            writer.println(stu);
        }
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}