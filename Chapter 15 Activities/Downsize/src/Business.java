import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Business utility methods.
*/
public class Business
{
    /**
      * Removes every nth element from the linked list
      *
      * @param employeeNames the linked list to remove from
      * @param n                 the parameter to determine "nth"
     */
    public static void downsize(LinkedList<String> employeeNames, int n)
    {
        //  removes every nth employee from a linked list. Use the ListIterator class. 
        ListIterator<String> iterator = employeeNames.listIterator();
        int num = 0;

        while (iterator.hasNext())
        {
            num++;
            iterator.next();
            
            if (num == n)
            {
                num = 0;
                iterator.remove();
            }
        }
    }
}