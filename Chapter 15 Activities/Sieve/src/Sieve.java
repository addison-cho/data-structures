import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        

        Set<Integer> nums = new HashSet<>();
        int i = 2;
        while(i<=n){
            nums.add(i);
            i++;
        }
        i = 2;
        
            Iterator iterator = nums.iterator();

        while(i<=n){
            while(iterator.hasNext()){
                int x = (int) iterator.next();
                if (x % i == 0 && x != i) {
                    iterator.remove();
                }
            }
                i++;
                iterator = nums.iterator();            

            }

        System.out.println(nums);
            System.out.println("k");



    }
}
