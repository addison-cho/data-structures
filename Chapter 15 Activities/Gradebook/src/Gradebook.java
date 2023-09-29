import java.util.Scanner;
import java.util.HashMap;
//. . .
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        HashMap<String, String> students = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            }
            else if (input.equals("A"))
            {
                System.out.println("Student's name: ");
                String name = new String(in.next());

                System.out.println("Student's Grade: ");
                String grade = new String(in.next());

                students.put(name, grade);

            }
            else if (input.equals("R"))
            {
                System.out.println("Student's name: ");
                String name = new String(in.next());

                students.remove(name);

            }
            else if (input.equals("M"))
            {
                System.out.println("Student's name: ");
                String name = new String(in.next());

                System.out.println("Student's Grade: ");
                String grade = new String(in.next());

                students.put(name, grade);
            }
            else if (input.equalsIgnoreCase("P"))
            {
                for (String x : students.keySet()) {
                    System.out.println(x + ": " + students.get(x));
                }
            } else
            {
                done = true;
            }
        }
        in.close();
    }
}
