import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Welcome!");
        boolean program = true;
        while(program){
            System.out.println("""
                    choose one of these below option
                    1) add option
                    2) display option
                    3) update option
                    4) delete option
                    or press anything to exit
                    """);
            char option = sc.next().charAt(0);
            if(option > '4' || option < '1')
                break;
            System.out.println("""
                    choose the department
                    c / C for Clients
                    e / E for Employees
                    r / R for Cars
                  """);
            char department = sc.next().charAt(0);
            switch(option) {
                case '1':
                    Management_System.selectAddDepartment(department);
                case '2':
                    Management_System.selectDisplayDepartment(department);
                case '3':
                    Management_System.selectUpdateDepartment(department);
                case '4':
                    Management_System.selectDeleteDepartment(department);
                default:
                    program = false;
                    break;
            }

        }
    }
}
