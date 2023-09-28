import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*
        the Map interface is generic
        the first type is the type of the key
        the second type is the type of the value
        */
        Map<String, Color> favColors = new HashMap<>();

        favColors.put("Hyder", Color.RED);
        favColors.put("Athena", Color.MAGENTA);
        favColors.put("Bavya", Color.BLUE);

        // two different keys can have the same value
        favColors.put("Mitchell", Color.RED);

        // the same key cannot have two different values
        // using .put for a key that exists changes the value
        favColors.put("Athena", Color.ORANGE);

        System.out.println(favColors.get("Athena"));

        // iterating through the keys
        Set<String> keys = favColors.keySet();
        for (String key: keys) {
            System.out.println(key + " (" + key.hashCode() + "): " + favColors.get(key));
        }
    }
}
