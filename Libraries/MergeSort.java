import static java.lang.System.*;
import java.util.Arrays;

public class MergeSort 
{
    public static int[] merge(int[] a, int[] b)
    {
        int size = a.length + b.length;
        if(size != 2)
        {
            int[] a1 = Arrays.copyOfRange(a,0,a.length/2);
            int[] a2 = Arrays.copyOfRange(a,a.length/2,a.length);
            a = merge(a1,a2);
            
            int[] b1 = Arrays.copyOfRange(b,0,b.length/2);
            int[] b2 = Arrays.copyOfRange(b,b.length/2,b.length);
            b = merge(b1,b2);
        }
        int[] ret = new int[size];
        int c = 0;
        int leftHead = 0;
        int rightHead = 0;
        while(c < size)
        {
            if(leftHead < a.length && rightHead < b.length && a[leftHead] < b[rightHead])
            {
                ret[c] = a[leftHead];
                c++;
                leftHead++;
            }
            else if(leftHead >= a.length)
            {
                ret[c] = b[rightHead];
                c++;
                rightHead++;
            }
            else if(rightHead >= b.length)
            {
                ret[c] = a[leftHead];
                c++;
                leftHead++;
            }
            else
            {
                ret[c] = b[rightHead];
                c++;
                rightHead++;
            }
        }
        out.print("ret: ");
        display(ret);
        return ret;
    }

    public static int[] sort(int[] ray)
    {
        int size = ray.length;
        int[] a = Arrays.copyOfRange(ray,0,ray.length/2);
        int[] b = Arrays.copyOfRange(ray,ray.length/2,ray.length);
        ray = merge(a,b);
        return ray;
    }

    public static void display(int[] ray)
    {
        String output = "";
        for(int i = 0; i < ray.length; i++)
        {
            output += ray[i] + " ";
        }
        out.println(output);
    }

    public static void main(String[] args)
    {
        int[] nums = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48,18};
        out.print("Before sort: ");
        display(nums);
        nums = sort(nums);
        out.print("After sort: ");
        display(nums);
    }
}