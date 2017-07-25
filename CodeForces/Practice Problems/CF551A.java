import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF551A
{
    static boolean isSecondStage = false;
    public static class Student implements Comparable
    {
        int position;
        int score;
        int rank;
        
        public Student(int p, int s)
        {
            position = p;
            score = s;
        }
        
        public void setRank(int r)
        {
            rank = r;
        }
        
        public int getRank()
        {
            return rank;
        }
        
        public int getPosition()
        {
            return position;
        }
        
        public int getScore()
        {
            return score;
        }
        
        public int compareTo(Object o)
        {
            if(!isSecondStage)
            {
                return ((Student)o).getScore()-score;
            }
            else
            {
                return position-((Student)o).getPosition();
            }
        }
        
        public String toString()
        {
            return ""+(rank+1);
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numStudents = Integer.parseInt(f.readLine());
        
        ArrayList<Student> students = new ArrayList<Student>();
        
        StringTokenizer st = new StringTokenizer(f.readLine());;
        
        for(int i = 0; i < numStudents; i++)
        {
            int position = i;
            int score = Integer.parseInt(st.nextToken());
            students.add(new Student(position,score));
        }
        
        Collections.sort(students);
        
        //In Score order
        
        //out.println(students);
        
        int prev = -1;
        int prevRank = -1;
        
        for(int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);
            if(prev==s.getScore())
            {
                s.setRank(prevRank);
            }
            else
            {
                s.setRank(i);
                prev = s.getScore();
                prevRank = i;
            }
            
            //out.println(s.getPosition());
        }
        
        isSecondStage = true;
        
        Collections.sort(students);
        
        for(int i = 0; i < students.size(); i++)
        {
            writer.print(students.get(i));
            if(i < students.size()-1)
            {
                writer.print(" ");
            }
        }
        writer.println();
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}