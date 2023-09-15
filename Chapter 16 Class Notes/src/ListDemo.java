/**
 *   A program that demonstrates the LinkedList class
 */

 import java.util.LinkedList;
 import java.util.ListIterator;

public class ListDemo
{
    public static void main(String[] args)
    {
        
        // the addLast method can be used to populate a list
        LinkedList<String> staff = new LinkedList();
        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");

        // list is currently: D, H, R, T
        /*
         * listIterator method creates a new list iterator
         * that is positioned at the head of the list.
         * 
         * The "|" is used to represent the iterator's position
         * 
         */

        ListIterator<String> iterator = staff.listIterator(); // |DHRT
        
        // next method advances iterator to next element in list
        iterator.next(); // D|HRT

        /* The next method also returns the element that the iterator is passing. */
        String name = iterator.next(); // H, DH|RT
        System.out.println(name);
        System.out.println("Expected: Harry");

        /*
         * The add method for iterators inserts an element at the iterator position.
         * The iterator is then positioned after the element that wasa added.
         */
        iterator.add("Juliet"); // DHJ|RT
        iterator.add("Nina"); // DHJN|RT

        /*
         * The remove method removes the element returned by the last call to next or previous.
         * The remove method can ONLY be called once after calling next or previous.
         * The remove method CANNOT be called after calling add.
         */
        iterator.next(); // DHJNR|T
        iterator.remove(); // DHJN|T

        System.out.println(staff);
        System.out.println("Expected: [Diana, Harry, Juliet, Nina, Tom]");

        /*
         * The set method updates the element returned by the last call to next or previous.
         */
        iterator.previous(); // DHJ|NT
        iterator.set("Albert"); // DHJ|AT
        
        /*
         * hasNext method returns true if the list has another element.
         * Often used in the condition of a while list
         */

        iterator = staff.listIterator();
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Juliet")) { 
                                    // DHJ|AT 
                iterator.remove(); // DH|AT
            }
        }

        // DHAT|

        // Enhanced for loops work with linked list
        for(String n:staff) {
            System.out.print(n + " ");
        }
        
        
        System.out.println("Expected: [Diana Harry Albert Tom]");

        iterator = staff.listIterator();
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Harry")) {
                //staff.remove("Diana");
                //ConcurrentModificationException, can't modify linkedlist while also using an iterator unless you use the iterator to do it
            }
        }

        /* An enhanced for loop AUTOMATICALLY creates an iterator */

        for (String n:staff) {
            if (n.equals("Harry")) {
                // staff.add("Charlie"); // also gives a concurrent modifcation error
            }
        }

        System.out.println(staff);
    }
}
