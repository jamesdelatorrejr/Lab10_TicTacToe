import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an int and ensure that it is an int
     */
    public static int getInt(Scanner pipe, String prompt) {
        int userInt = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                userInt = pipe.nextInt();
                done = true;
            } else {
                System.out.println("Please enter an int.");
                done = false;
                pipe.nextLine();
            }
        } while (!done);

        return userInt;

    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double and ensure that it is a double
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double userDouble = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                userDouble = pipe.nextDouble();
                done = true;
            } else {
                System.out.println("Please enter an double.");
                done = false;
                pipe.nextLine();
            }
        } while (!done);

        return userDouble;

    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param lo     low range for int
     * @param hi     high range for int
     * @return an int and ensure that it is an int
     */
    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi) {
        int userInt = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                userInt = pipe.nextInt();
                done = true;
            } else {
                System.out.println("Please enter an int.");
                done = false;
                pipe.nextLine();
            }
            if (userInt >= lo && userInt <= hi && done) {
                System.out.println("You have entered a number " + userInt + " that is in range.");
            } else if (!done) {

            } else {
                done = false;
                System.out.println("Number " + userInt + " is not in range. Please pick a number between " + lo + "-" + hi);
            }
        } while (!done);

        return userInt;

    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param lo     low range for double
     * @param hi     high range for double
     * @return a double and ensure that it is a double
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double lo, double hi) {
        double userDouble = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                userDouble = pipe.nextDouble();
                done = true;
            } else {
                System.out.println("Please enter a double.");
                done = false;
                pipe.nextLine();
            }
            if (userDouble >= lo && userDouble <= hi && done) {
                System.out.println("You have entered a number " + userDouble + " that is in range.");
            } else if (!done) {

            } else {
                done = false;
                System.out.println("Number " + userDouble + " is not in range. Please pick a number between " + lo + "-" + hi);
            }
        } while (!done);

        return userDouble;
    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a boolean true for Y, false for N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean userYN = false;
        String userInt = "";
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextLine()) {
                userInt = pipe.nextLine();
            } else {
                System.out.println("Please enter a string.");
                pipe.nextLine();
            }
            if (userInt.equalsIgnoreCase("Y")) {
                userYN = true;
                done = true;
            } else if (userInt.equalsIgnoreCase("N")) {
                userYN = false;
                done = true;

            } else {
                System.out.println("There is an error in your input, please put a Y/N.");
                done = false;
            }

        } while (!done);

        return userYN;
    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx  string given to match
     * @return a String equal or not equal to the regex string
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String userString = "";
        boolean done = false;
        boolean done1 = false;
        do {
            do {
                System.out.println("\n" + prompt + ": ");
                if (pipe.hasNextLine()) {
                    userString = pipe.nextLine();
                    done = true;
                } else {
                    System.out.println("Please enter a string.");
                    pipe.nextLine();
                }
            } while (!done);

            Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(userString);
            done = false;

            boolean userEqRegEx = matcher.find();


            if (userEqRegEx == true) {
                System.out.println(regEx + " pattern was found.");
                done1 = true;
            } else {
                System.out.println("The pattern " + regEx + " was not found.");
            }
        } while (!done1);

        return userString;
    }


    /**
     * @param msg       a Scanner opened to read from System.in
     * @return a String equal or not equal to the regex string
     */
    static String PrettyHeader(String msg) {
        int lineLength = 60;
        String formattedMsg = "";
        int msgLength = msg.length();
        int spaceLength = (lineLength - msgLength - 6) / 2;
        String space = "";
        String starLine = "";

        for (int i = 0; i < spaceLength+1; i++) {
            space += " ";
        }

        for (int i = 0; i < lineLength+1; i++) {
            starLine += "*";
        }

        formattedMsg += starLine + "\n" + "***" + space + msg + space + "***" + "\n" + starLine;

        return formattedMsg;
    }
}
