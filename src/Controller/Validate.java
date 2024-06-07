package Controller;

import Model.Employee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

/** validation class checks user input
 *
 * @author Admin
 */
public class Validate {

    private static final Scanner in = new Scanner(System.in);

    private static final String PHONE_VALID = "[0-9]+";
    private static final String STRING_VALID = "[a-zA-Z]*";
    private static final String EMAIL_VALID = "^[a-zA-Z0-9_]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";
    private static final String ADDRESS_VALID = "[ 0-9a-zA-Z,.-]*";
    private static final String ID_VALID = "[a-zA-Z0-9]*";
    
    /**
     * check input year
     *
     * @return result as valid year
     */
    public static String checkInputDOB() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();

            // Define the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                // Try to parse the user input to a LocalDate object
                LocalDate date = LocalDate.parse(result, formatter);

                // If parsing is successful, the date is valid and exists
                return result;
            } catch (DateTimeParseException e) {
                // If an exception is thrown, the date is not valid
                System.out.println("Invalid date format or non-existent date!");
            }
        }
    }

    /**
     * check input email
     *
     * @return result as valid email
     */
    public static String checkInputEmail() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty() || !(result.matches(EMAIL_VALID))) {
                System.out.println("Invalid email!");
                System.out.print("Enter again:");
            } else {
                return result;
            }
        }
    }

    /**
     * check input address
     *
     * @return result as valid address
     */
    public static String checkInputAddress() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty() || !(result.matches(ADDRESS_VALID))) {
                System.out.println("Invalid email!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
/**
     * check input ID
     *
     * @return result as valid string
     */
    public static String checkInputID() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty() || !(result.matches(ID_VALID))) {
                System.out.println("Not empty, and no spaces!");
                System.out.print("Enter again:");
            } else {
                return result;
            }
        }
    }
    
    /**
     * check input String
     *
     * @return result as valid string
     */
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty() || !(result.matches(STRING_VALID))) {
                System.out.println("Not empty, and no spaces or numbers!");
                System.out.print("Enter again:");
            } else {
                return result;
            }
        }
    }

    /**
     * check input int
     *
     * @return result as valid int
     */
    public static int checkInputInt() {
        while (true) {
            //loop until input valid
            try {
                int result = Integer.parseInt(in.nextLine());
                //get user input

                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Must be a number");
                System.out.println("Enter again:");
            }
        }
    }

    /**
     * check input in range min max
     *
     * @param min minimal choice
     * @param max maximal choice
     * @return choice as valid choice
     */
    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(in.nextLine());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                    //throw exception if input is out of valid range
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Please input a number");
                System.out.println("Enter again:");
            }
        }
    }

    /**
     * check input phone number
     *
     * @return result as valid phone number
     */
    public static String checkInputPhone() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                if (result.matches(PHONE_VALID)) {
                    return result;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Phone must be 10 digits, and no spaces");
                System.out.println("Enter again:");
            }
        }
    }

    /**
     * check ID existing or not
     *
     * @param ID checking ID
     * @param employeeList checking list
     * @return false if existed/ true if not existed
     */
    public static boolean checkExistingID(String ID, ArrayList<Employee> employeeList) {
        boolean result=true;
        for (Employee employee : employeeList) {
            if (ID.equals(employee.getId())) {
                result = false;
            }
        }
        return result;
    }
}
