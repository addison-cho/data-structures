import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        //String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample1.html";
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample2.html";
        //String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample1.html";

        Stack<String> tags = new Stack<>();

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            in.useDelimiter(" ");

            while(in.hasNext()) {
                System.out.println(tags);
                String x = in.next();
                if (!x.contains("/")) {
                    tags.push(x);
                }
                else {
                    System.out.print("Checking: ");
                    System.out.print(tags.peek());
                    System.out.println(x);
                    if (tags.peek().substring(1, tags.peek().indexOf(">")).equals(x.substring(2, x.indexOf(">"))))
                        tags.pop();
                }
            }
            System.out.println(tags);

            if(tags.size() == 0)
                System.out.println("True");
            else
                System.out.println("False");

        }

        catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + filename);
        }

    }
}
