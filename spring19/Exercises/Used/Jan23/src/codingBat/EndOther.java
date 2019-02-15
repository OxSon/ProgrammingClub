package codingBat;

/**
 * Author: Alec Mills
 */

public class EndOther {
    public static boolean aContainsB(String a, String b) {
        //edge cases
        if (!lengthCheck(a, b))
            return false;
        if (a.length() == b.length())
            return a.equals(b);

        a = a.toLowerCase();
        b = b.toLowerCase();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0)) {
                if (lengthCheck(a.substring(i), b) && a.substring(i,
                        i + b.length()).equals(b))
                    return true;
            }
        }

        return false;
    }

    public static boolean endOther(String a, String b) {
        return aContainsB(a, b) || aContainsB(b, a);
    }

    private static boolean lengthCheck(String a, String b) {
        return a.length() >= b.length();
    }

    public static void main(final String[] args) {
        Object[][] testData = {
                {"a;lsjg", ";", false},
                {"a;lsjg", ";", false},
                {"HiaBc", "abc", true},
                {"Hiabc", "abcd", false},
                {"Z", "12xz", true},
                {"12", "12", true},
                {"a;lsjg", ";", true}
        };

        for(Object[] dataSet : testData) {
            String a = (String) dataSet[0];
            String b = (String) dataSet[1];
            boolean goal = (boolean) dataSet[2];

            System.out.printf("(%s, %s) %s!", a, b, endOther(a, b) == goal ?
                    "PASSED" : "FAILED");
        }
    }
}

