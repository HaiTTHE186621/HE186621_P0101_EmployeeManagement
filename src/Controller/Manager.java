package Controller;

import Model.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Manager class contains employee managing functions
 * @author Admin
 */
public class Manager {

    private static final Scanner in = new Scanner(System.in);

    /**
     * employee adding function
     *
     * @param employeeList list of employees
     */
    public static void addEmployee(ArrayList<Employee> employeeList) {
        System.out.println("Enter ID:");
        String ID = Validate.checkInputID();
        if (!Validate.checkExistingID(ID, employeeList)) {
            //if ID exist return to menu
            System.out.println("ID existed");
            return;
        }
        System.out.println("Enter first name:");
        String firstName = Validate.checkInputString();
        System.out.println("Enter last name:");
        String lastName = Validate.checkInputString();
        System.out.println("Enter phone:");
        String phone = Validate.checkInputPhone();
        System.out.println("Enter email:");
        String email = Validate.checkInputEmail();
        System.out.println("Enter Address:");
        String address = Validate.checkInputAddress();
        System.out.println("Enter date of birth by format dd-mm-yyyy:");
        String year = Validate.checkInputDOB();
        System.out.println("Enter sex:");
        String sex = Validate.checkInputString();
        System.out.println("Enter salary:");
        int salary = Validate.checkInputInt();
        System.out.println("Enter agency:");
        String agency = Validate.checkInputString();
        employeeList.add(new Employee(ID, firstName, lastName, phone, email, address, year, sex, salary, agency));
        //adding employee info
        System.out.println("Add successfully");
    }

    /**
     * update employee by ID function
     *
     * @param employeeList list of employees
     */
    public static void updateEmployee(ArrayList<Employee> employeeList) {
        System.out.println("Enter employee ID for updating:");
        String ID = Validate.checkInputID();
        //input updating employee's ID
        for (Employee employee : employeeList) {
            if (ID == employee.getId()) {
                System.out.println("=========================");
                System.out.println("1.First name");
                System.out.println("2.Last name");
                System.out.println("3.Phone number");
                System.out.println("4.Email");
                System.out.println("5.Address");
                System.out.println("6.Year of Birth");
                System.out.println("7.Sex");
                System.out.println("8.Salary");
                System.out.println("9.Agency");
                System.out.println("0.Return");
                System.out.println("Choose updating field:");
                //menu updating info
                int choice = Validate.checkIntLimit(0, 9);
                switch (choice) {
                    case 1:
                        System.out.println("Enter first name:");
                        employee.setFirstName(Validate.checkInputString());
                        break;
                    case 2:
                        System.out.println("Enter last name:");
                        employee.setLastName(Validate.checkInputString());
                        break;
                    case 3:
                        System.out.println("Enter phone:");
                        employee.setPhone(Validate.checkInputPhone());
                        break;
                    case 4:
                        System.out.println("Enter email:");
                        employee.setEmail(Validate.checkInputEmail());
                        break;
                    case 5:
                        System.out.println("Enter Address:");
                        employee.setAddress(Validate.checkInputAddress());
                        break;
                    case 6:
                        System.out.println("Enter year of birth:");
                        employee.setDOB(Validate.checkInputDOB());
                        break;
                    case 7:
                        System.out.println("Enter sex:");
                        employee.setSex(Validate.checkInputString());
                        break;
                    case 8:
                        System.out.println("Enter salary:");
                        employee.setSalary(Validate.checkInputInt());
                        break;
                    case 9:
                        System.out.println("Enter agency:");
                        employee.setAgency(Validate.checkInputString());
                        break;
                    // updating info options
                }
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("ID not found!");
    }

    /**
     * remove employee by ID function
     *
     * @param employeeList list of employees
     */
    public static void removeEmployee(ArrayList<Employee> employeeList) {
        System.out.println("Enter employee ID for removing:");
        String ID = Validate.checkInputID();
        //input employee ID for removing
        for (Employee employee : employeeList) {
            if (ID == employee.getId()) {
                employeeList.remove(employee);
                System.out.println("Removed!");
                //remove if ID matches
                return;
            }
        }
        System.out.println("ID not found!");
    }

    /**
     * search employees by name funtion
     *
     * @param employeeList list of employees
     */
    public static void searchEmployee(ArrayList<Employee> employeeList) {
        ArrayList<Employee> employeeFound = new ArrayList<>();
        //list of employees found
        System.out.println("Enter searching name:");
        String search = Validate.checkInputString();
        //input searching name
        for (Employee employee : employeeList) {
            if (employee.getFirstName().toLowerCase().contains(search.toLowerCase())
                    || employee.getLastName().toLowerCase().contains(search.toLowerCase())) {
                employeeFound.add(employee);
                //add employee if matches
            }
        }
        System.out.println("Found employees:");
        for (Employee employee : employeeFound) {
            System.out.println(employee);
            //print matched employee info 
        }
    }

    /**
     * sort by salary function
     *
     * @param employeeList list of employees
     */
    public static void sortBySalary(ArrayList<Employee> employeeList) {
        // Define a custom comparator to sort by salary
        Comparator<Employee> salaryComparator = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());

        // Sort the employee list based on the comparator
        Collections.sort(employeeList, salaryComparator);

        // Print sorted employees
        System.out.println("Sorted by salary:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
