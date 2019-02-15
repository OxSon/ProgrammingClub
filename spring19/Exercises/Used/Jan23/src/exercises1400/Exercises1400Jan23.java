package exercises1400;


import java.util.ArrayList;

/**
 * Author: Ethan Darling L& Alec Mills
 *
 * Below are some coding challenges. In each there is a description of the
 * goal, a set of example Input/Output, and a method signature.
 *
 * The main method tests each of the challenges. Good luck and don't be
 * afraid to ask for help from your neighbor or a Programming Club member!
 */

public class Exercises1400Jan23 {

    /**
     * Step 1: Given a variable number of String objects (representing color),
     * create an ArrayList containing all of those values, except the last one
     * NOTE: method returns null when fewer than 3 Strings are passed to it.
     *
     * e.g. passing in an array wtih one element, like {"red"} would return an empty ArrayList.
     *      passing in an array with three elements, like {"red", "blue", "yellow"},
     *      would produce an ArrayList with the values {"red", "blue"}
     *
     * Step 2: Remove the first element in the ArrayList
     * e.g. {"red", "blue", "yellow"} becomes {"blue, "yellow"}
     *
     * Step 3: Finally, return the first element in the list, concatonated with
     * the last
     * e.g. {"red", "blue", "yellow"} returns {"redyellow"}
     *
     * OVERVIEW:
     * e.g. {"red", "blue", "yellow"} becomes "blueblue"
     *      {"green", "red", "blue", "yellow"} becomes "redblue"
     *
     * A skeleton implementation has been provided to jumpstart the process
     */
    private static String colorsList(String[] colors) {
        if (colors.length < 3)
            return null;

        //example beginning NOTE: may want to delete result.add(colors[0])
        ArrayList<String> result = new ArrayList<>();
        result.add(colors[0]);

        //TODO
        // your solution here

        return result.get(0) + result.get(result.size() - 1);
    }

    /** We'll say that a number is "teen" if it is in the range 13..19
     * inclusive. Given 2 int values, return true if one or the other is teen,
     * but not both.
     * Example input and result:
     * loneTeen(13, 99) → true
     * loneTeen(21, 19) → true
     * loneTeen (13, 13) → false
     */
    private static boolean loneTeen(int a, int b) {
        //TODO
        // your solution here
        return false;
    }



    /**
     * Run the main method to test your implementations, results will be printed to the console
     */
    public static void main(String[] args) {
        // testing colorsList()
        String[] colors = {"red", "blue", "green", "yellow", "ziggleForp"};

        System.out.printf("Test of colorsList: %s%n", testColorsList(colors) ? "PASSED!" : "FAILED!");
        System.out.print("Data: ");
        printStrings(colors);
        System.out.printf("%nResult: %s", colorsList(colors));

        System.out.printf("%n%nTest of loneTeen: %s%n", testLoneTeen() ?
                "PASSED" : "FAILED");
    }

    private static boolean testColorsList(String[] colors) {
        String result = colorsList(colors);
        if ((colors.length < 3 && result != null) ||
                (colors.length >= 3 && result == null))
            return false;

        assert result != null;

        return result.equals(colors[1] + colors[colors.length - 2]);
    }

    private static boolean testLoneTeen() {
        int[][] testData = {
                {13, 13, 0}, //false
                {14, 20, 1}, //true
                {16, 9, 1}, //true
                {16, 17, 0}, //false
                {99, 99, 0} //false
        };
        for(int[] data : testData) {
            if (loneTeen(data[0], data[1]) != (data[2] == 1))
                return false;
        }

        return true;
    }

    private static void printStrings(String[] stuff) {
        for(String el : stuff) {
            System.out.printf("%s ", el);
        }
    }
}
