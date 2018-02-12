import java.util.ArrayList;

/**
 * Created by mil on 2/12/2018 AD.
 */

public class ArrayListExample {
    public static void main (String[] args) {

        ArrayList<String> names = new ArrayList<String>();
        names.add("one");
        names.add("two");
        names.add("three");
        names.add("four");
        names.add("five");
        names.add("six");
        names.add("seven");
        names.add("eight");

        System.out.println(names.size() + " people in the list");

        // Access list through  it index
        System.out.println("name[0] = " + names.get(0));
        System.out.println("name[3] = " + names.get(3));

        // Iterate through ArrayList usign foreach
        for (String name: names) {
            System.out.print(name + " ");
        }
        System.out.println();
        System.out.println("----");

        //Loop ArrayList
        for (int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }
        System.out.println("----");

        // Iterate through ArrayList using index (reverse)
        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.print(names.get(i) + " ");
        }
        System.out.println();

        // Check if the list contain one
        if (names.contains("one")) {
            System.out.println("one is in the list");
        } else {
            System.out.println("one is not in the list");
        }

        // Get two's index
        int twoIndex = names.indexOf("two");
        System.out.println("Index of two is " + twoIndex);
        // Change Danny to Max
        names.set(twoIndex, "three");

        // Remove joe from the list
        names.remove("three");

        // Iterate through ArrayList usign foreach
        for (String name: names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // Clear all list data
        names.clear();

        if(names.isEmpty()) {
            System.out.println("List is now empty");
        }

    }
}
