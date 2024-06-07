package View;

import Model.Employee;
import Controller.Manager;
import Controller.Validate;
import java.util.ArrayList;

public class Main {

    /**
     * employee management program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        while (true) {
            System.out.println("1.Add employee");
            System.out.println("2.Update employee");
            System.out.println("3.Remove employee");
            System.out.println("4.Search employee");
            System.out.println("5.Sort employee by salary");
            System.out.println("6.Exit");
            System.out.println("Enter choice:");
            int choice = Validate.checkIntLimit(1, 6);
            switch (choice) {
                case 1:
                    Manager.addEmployee(employeeList);
                    break;
                case 2:
                    Manager.updateEmployee(employeeList);
                    break;
                case 3:
                    Manager.removeEmployee(employeeList);
                    break;
                case 4:
                    Manager.searchEmployee(employeeList);
                    break;
                case 5:
                    Manager.sortBySalary(employeeList);
                    break;
                case 6:
                    return;
            }
        }
    }

}
