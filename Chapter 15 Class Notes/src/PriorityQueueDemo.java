import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // create a priority queue of to-do items
        // WorkOrder has a message ID that is used to determine priority
        // a priority queue can only store Comparable objects
        Queue<WorkOrder> todo = new PriorityQueue<>();
        todo.add(new WorkOrder(3, "water plants"));
        todo.add(new WorkOrder(2, "make dinner"));
        todo.add(new WorkOrder(2, "walk dog"));
        todo.add(new WorkOrder(9, "play videogames"));
        todo.add(new WorkOrder(1, "study for chapter 15 exam"));

        System.out.println(todo);
        while (todo.size() > 0) {
            System.out.println(todo.remove());
        }
    }
}
