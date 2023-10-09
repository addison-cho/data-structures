import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
        Stack<String> stack = new Stack<>();
    	
        String newSentence = "";
        // Complete this method. Use a Stack.
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!word.contains(".")) {
                stack.push(word.toLowerCase());
            } else {
                stack.push(word.substring(0,1).toUpperCase() + word.substring(1,word.length()-1));
                while(!(stack.size()==0)) {
                    newSentence += stack.pop();
                    newSentence += " ";
                }
                newSentence = newSentence.substring(0,newSentence.length()-1);
                newSentence+=". ";
            }

        }


        /*
        while(!(stack.size()==0)) {
            newSentence += stack.pop();
            newSentence += " ";
        }
        */

        

        return newSentence;
    }
}
