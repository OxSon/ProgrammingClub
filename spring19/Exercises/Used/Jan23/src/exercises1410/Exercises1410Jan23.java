package exercises1410;

/**
 * Author: Alec Mills
 *
 * Below are some coding challenges. In each there is a description of the
 * goal, a set of example Input/Output, and a method signature.
 *
 * The main method tests each of the challenges. Good luck and don't be
 * afraid to ask for help from your neighbor or a Programming Club member!
 */

public class Exercises1410Jan23 {
    /**
     * For this problem,we'll round an int value up to the next multiple of 10
     * if its rightmost digit is 5 or more, so 15 rounds up to 20.
     * Alternately, round down to the previous multiple of 10 if its rightmost
     * digit is less than 5, so 12 rounds down to 10. Given 3 ints, a b c,
     * return the sum of their rounded values. To avoid code repetition,
     * write a separate helper "public int round10(int num) {" and call it 3
     * times. Write the helper entirely below and at the same indent level as
     * roundSum().
     * <p>
     * Example inputs and results:
     * roundSum(16, 17, 18) → 60
     * roundSum(12, 13, 14) → 30
     * roundSum(6, 4, 4) → 10
     */
    private static int roundSum(int a, int b, int c) {
        //TODO
        // your solution here
        int sum = roundInt(a);
        sum += roundInt(b);
        sum += roundInt(c);

        return sum;
    }

    private static int roundInt(int a) {
        int mod = a % 10;
        if (mod >= 5) {
            return a + (10 - mod);
        }

        return a - mod;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is
     * another 'g' immediately to its left or right. Return true if all the
     * g's in the given string are happy.
     * Example input and result:
     * gHappy("xxggxx") → true
     * gHappy("xxgxx") → false
     * gHappy("xxggyygxx") → false
     */
    public static boolean gHappy(String str) {
        //TODO
        // your solution goes here
        return false;
    }

    public static void main(String[] args) {
        boolean roundSumFailure =
                roundSum(16, 17, 18) != 60 ||
                        roundSum(12, 13, 14) != 30 ||
                        roundSum(6, 4, 4) != 10 ||
                        roundSum(0, 0, 1) != 0 ||
                        roundSum(24, 36, 32) != 90 ||
                        roundSum(12, 10, 24) != 40;

        System.out.printf("Test roundSum(): %s!%n", !roundSumFailure ?
                "PASSED" : "FAILED");

        System.out.printf("Test gHappy(): %s!%n", testgHappy() ? "PASSED" :
                "FAILED");
    }

    public static boolean testgHappy() {
        boolean success = false;
        Tuple[] strings = {
                new Tuple("xxggxx", true),
                new Tuple("xxgxx", false),
                new Tuple("gg", true),
                new Tuple("", true)
        };

        for (Tuple el : strings) {
//            success = gHappy(el.str) == el.goal;
            success = gHappySolution(el.str) == el.goal;
        }

        return success;
    }

    private static boolean gHappySolution(String str) {
        int[] indicies = new int[str.length()];
        boolean happy = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                happy = letterHappy(str, i);
                if(!happy)
                    return false;
            }
        }

        return true;
    }

    private static boolean letterHappy(String str, int i) {
        if (i < 0 || i >= str.length())
            throw new IllegalArgumentException();

        char let = str.charAt(i);

        if (i == 0) {
            return str.charAt(1) == let;
        } else if (i == str.length() - 1) {
            return str.charAt(i - 1) == let;
        } else {
            return str.charAt(i - 1) == let && str.charAt(i + 1) == let;
        }
    }

    static class Tuple {
        String str;
        boolean goal;

        Tuple(String str, boolean goal) {
            this.str = str;
            this.goal = goal;
        }
    }
}
