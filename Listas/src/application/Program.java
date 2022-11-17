package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> listEmp = new ArrayList<>();

        //Part 1 - Reading Data:
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        for (int i =0; i<=n; i++){
            System.out.println();
            System.out.print("Employee #"+ (i+1) + " id: ");
            int id = sc.nextInt();
            while (hasId(listEmp,id)){
                System.out.print("Id already taken. Try again: ");
                id= sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            listEmp.add(new Employee(id,name,salary));
        }

        //Part 2 - Update Salary of Given Employee:
        Employee emp;
        double percentage;
        System.out.println();
        do {
            System.out.print("Enter the employee id that will have salary increase: ");
            int id = sc.nextInt();
            emp = listEmp.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

            if (emp == null){
                System.out.println("This id does not exist!");
            }
            else {
                System.out.print("Enter the percentage: ");
                percentage = sc.nextDouble();
                emp.increaseSalary(percentage);
            }
        }while (emp == null);

        // Part 3 - Listing Employees:
        System.out.println();
        System.out.println("List of employees: ");
        for (Employee obj: listEmp){
            System.out.println(obj);
        }

        sc.close();
    }
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
