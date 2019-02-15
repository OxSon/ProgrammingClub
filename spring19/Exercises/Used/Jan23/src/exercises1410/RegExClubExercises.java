package exercises1410;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Author: Alec Mills
 */

public class RegExClubExercises {
    /**
     The following is an example of how one would translate a String into a
     Pattern:

     static Pattern pattern = Pattern.compile("([wW])oodchuck(s)?");
     */

    //your solutions goes here (fill in the empty string with regex:
    static String[] solutions = {
            //for each comment, edit the empty string below it to
            // contain a regex that matches the provided input

            // woodchuck, Woodchuck, woodchucks, Woodchucks
            "",

            // dates in MM-DD-YY format e.g. 12-09-1998, 09-10-1974
            "",

            // any valid variable name
            // valid variables start with an alphanumeric character, a
            // dollar sign, or an underscore,
            // subsequent characters can also include the digits 0-9
            // whitespace is not allowed in variable names
            // for the purposes of this exercise it is okay to not exclude
            // reserved keywords (private, etc)
            ""

    };
    public static void main(final String[] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.println("Example tests: ");
        new DataTuple("woodchuck", true, "woodchuck").testAttempt("[wW" +
                "]oodchuck(s)?");
        new DataTuple("WoodchuckSs", false, "woodchuck").testAttempt("[wW" +
                "]oodchuck[sS" +
                "]{1," +
                "2}");
        System.out.println(); //formatting output

        System.out.println("Your tests" );
        for(int i = 0; i < solutions.length; i++) {
            System.out.println(tests[i][0].name);
            for(int j = 0; j < tests[i].length; j++) {
                tests[i][j].testAttempt(solutions[i]);
            }
            System.out.println(); //format output
        }

        //Check the end of a file for an interesting regex problem if you've
        // finished the rest and are looking for an extra challenge,
        //then un-comment out the following two lines
//        System.out.println("Extra challenge: ");
//        extraChallenge();
    }


    static class DataTuple {
        String name;
        String input;
        boolean expected;

        DataTuple(String input, boolean expectedResult, String name) {
            this.input = input;
            this.expected = expectedResult;
            this.name = name;
        }

        private void testAttempt(String pattern) {
            boolean match = Pattern.matches(pattern, input);
            System.out.printf("%-7s %-10s %-30s %-25s%n",
                    match == expected ? pass + " PASS " : fail + " FAIL ",
                    input, expected ? "should match:" : "should not match:",
                    pattern);
        }
    }

    static char pass = '\u2713';
    static char fail = '\u0078';

    static DataTuple[][] tests = {
            //woodchucks
            {new DataTuple("Woodchucks", true, "Woodchucks"),
            new DataTuple("WooDchuCkS", false, "Woodchucks")},
            //dates MM-DD-YY
            {new DataTuple("12-09-1974", true, "Dates"),
            new DataTuple("14-10-0093", false, "Dates"),
            new DataTuple("03 10 1994", false, "Dates")},
            //variable names
            {new DataTuple("my_var", true, "Variables"),
            new DataTuple("_my_var", true, "Variables"),
            new DataTuple("9myvar", false, "Variables"),
            new DataTuple("my var", false, "Variables")},
    };

    static DataTuple[] extraTests = { //IP address
            new DataTuple("192.168.0.1", true, "IPs"),
            new DataTuple("192.168", false, "IPs"),
            new DataTuple("256.255.255.255", false, "IPs"),
            new DataTuple(".255.255.255.255", false, "IPs"),
            new DataTuple("hello.mate.howre.you", false, "IPs")
    };


    public static void extraChallenge() {
        //Match any IP address; an IP address is in the form A.B.C.D
        //where A/B/C/D are all in the range [0,255].
        //Some valid addresses:
        // 000.12.12.034
        // 121.234.12.12
        // 23.45.12.56
        //Some invalid:
        // .213.123.23.32
        // 23.45.22.32.
        // I.Am.not.an.ip
        String pattern = "";

        for(DataTuple el : extraTests) {
            el.testAttempt(pattern);
        }
    }
}
