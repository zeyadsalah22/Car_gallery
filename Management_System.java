import java.util.*;
public class Management_System {
    private static ArrayList<Employee> staff = new ArrayList<Employee>();
    private static ArrayList<Client> clients = new ArrayList<Client>();
    private static ArrayList<Car> goods = new ArrayList<Car>();
    static Scanner sc = new Scanner(System.in);
    private static double budget;

    private static int selectDepartment(char c){
        return switch (c) {
            case 'e', 'E' -> 1;
            case 'c', 'C' -> 2;
            case 'r', 'R' -> 3;
            default -> 0;
        };
    }

    public static void selectDisplayDepartment(char department) {
        int option = selectDepartment(department);
        switch (option) {
            case 1 -> displayStaff();
            case 2 -> displayClient();
            case 3 -> displayCar();
            default -> {
            }
        }
    }
    public static void displayStaff(){
        System.out.println("Our Staff:");
        for (Employee employee : staff) {
            employee.displayUser();
        }
    }
    public static void displayClient(){
        System.out.println("Our Clients:");
        for (Client client : clients) {
            client.displayUser();
        }
    }
    public static void displayCar(){
        System.out.println("Our Cars:");
        for (Car good : goods) {
            good.displayCar();
        }
    }

    public static void selectAddDepartment(char department) {
        int option = selectDepartment(department);
        switch (option) {
            case 1 -> addEmployee();
            case 2 -> addClient();
            case 3 -> addCar();
            default -> {
            }
        }
    }

    public static Object addUser(boolean client){
        System.out.println("Enter First Name");
        String first = sc.next();
        System.out.println("Enter Second Name");
        String second = sc.next();
        System.out.println("Enter Age");
        int age = sc.nextInt();
        System.out.println("Are you married?\nenter 1 for yes and 0 for no");
        boolean married = sc.nextBoolean();
        if(client)
            return new Client(first, second, age,clients.size() + 1, married);
        else
            return new Employee(first, second, age, staff.size() + 1, married);
    }
    public static void addEmployee(){
        Employee e = (Employee) addUser(false);
        System.out.println("Enter Position");
        String position = sc.next();
        System.out.println("Enter Salary");
        double salary = sc.nextDouble();
        e.setPosition(position);
        e.setSalary(salary);
        staff.add(e);
    }
    public static void addClient(){
        Client c = (Client) addUser(true);
        System.out.println("Enter budget");
        double budget = sc.nextDouble();
        c.setBudget(budget);
        clients.add(c);
    }
    public static void addCar(){
        System.out.println("Enter car's brand");
        String brand = sc.next();
        System.out.println("Enter car's model");
        String model = sc.next();
        System.out.println("Enter car's price");
        double price = sc.nextDouble();
        budget-=price;
        Car c = new Car(brand,model,price*(1.1));
        goods.add(c);
    }

    public static void selectUpdateDepartment(char department) {
        int option = selectDepartment(department);
        switch (option) {
            case 1 -> updateEmployee();
            case 2 -> updateClient();
            case 3 -> updateCar();
            default -> {
            }
        }
    }
    public static void updateClient(){
        System.out.println("Select the id of the client you want to update");
        displayClient();
        int id = sc.nextInt();
        if(id < 0 || id > clients.size()) {
            System.out.println("Invalid id!!\n");
            return;
        }
        clients.get(id).displayUser();
        System.out.println("""
            choose the label you want to change
            1) first name
            2) second name
            3) age
            4) married status
            5) car
            """);
        switch (sc.next().charAt(0)){
            case '1':
                System.out.println("Enter the first name");
                clients.get(id).setFirstName(sc.next());
                break;
            case '2':
                System.out.println("Enter the second name");
                clients.get(id).setLastName(sc.next());
                break;
            case '3':
                System.out.println("Enter the age");
                clients.get(id).setAge(sc.nextInt());
                break;
            case '4':
                System.out.println("married? 1 for yes, 0 for no");
                clients.get(id).setMarried(sc.nextBoolean());
                break;
            case '5':
                System.out.println("enter the details for the car");
                
        }

    }
    public static void updateEmployee(){
        System.out.println("Select the id of the employee you want to update");
        displayStaff();
        int id = sc.nextInt();
        if(id < 0 || id > staff.size()) {
            System.out.println("Invalid id!!\n");
            return;
        }
        staff.get(id).displayUser();
        System.out.println("""
            choose the label you want to change
            1) first name
            2) second name
            3) age
            4) married status
            5) position
            6) salary
            """);
        switch (sc.next().charAt(0)){
            case '1':
                System.out.println("Enter the first name");
                staff.get(id).setFirstName(sc.next());
                break;
            case '2':
                System.out.println("Enter the second name");
                staff.get(id).setLastName(sc.next());
                break;
            case '3':
                System.out.println("Enter the age");
                staff.get(id).setAge(sc.nextInt());
                break;
            case '4':
                System.out.println("married? 1 for yes, 0 for no");
                staff.get(id).setMarried(sc.nextBoolean());
                break;
            case '5':
                staff.get(id).updatePosition();
                System.out.println("position updated to manager!");
                break;
            case '6':
                System.out.println("Enter the salary");
                staff.get(id).setSalary(sc.nextDouble());
            default:
                break;

        }
    }
    public static void updateCar(){
        System.out.println("Select the id of the car you want to update");
        displayCar();
        int id = sc.nextInt();
        if(id < 0 || id > goods.size()) {
            System.out.println("Invalid id!!\n");
            return;
        }
        goods.get(id).displayCar();
        System.out.println("""
            choose the label you want to change
            1) brand
            2) model
            3) price
            """);
        switch (sc.next().charAt(0)) {
            case '1' -> {
                System.out.println("Enter the new brand");
                goods.get(id).setBrand(sc.next());
            }
            case '2' -> {
                System.out.println("Enter the new model");
                goods.get(id).setModel(sc.next());
            }
            case '3' -> {
                System.out.println("Enter the new price");
                goods.get(id).setPrice(sc.nextDouble());
            }
        }
    }


    public static void selectDeleteDepartment(char department) {
        int option = selectDepartment(department);
        switch (option) {
            case 1 -> deleteEmployee();
            case 2 -> deleteClient();
            case 3 -> deleteCar();
            default -> {
            }
        }
    }
    public static void deleteClient(){
        System.out.println("Select the id of the client you want to delete");
        displayClient();
        int id = sc.nextInt();
        if(id < 0 || id > clients.size()) {
            System.out.println("Invalid id!!\n");
            return;
        }
        clients.remove(clients.get(id));
        System.out.println("The client has been deleted!");
    }
    public static void deleteEmployee(){
        System.out.println("Select the id of the employee you want to delete");
        displayStaff();
        int id = sc.nextInt();
        if(id < 0 || id > staff.size()) {
            System.out.println("Invalid id!!\n");
            return;
        }
        staff.remove(staff.get(id));
        System.out.println("The employee has been deleted!");
    }
    public static void deleteCar(){
        System.out.println("Select the id of the car you want to delete");
        displayCar();
        int id = sc.nextInt();
        if(id < 0 || id > goods.size()) {
            System.out.println("Invalid id!!\n");
            return;
        }
        goods.remove(goods.get(id));
        System.out.println("The car had been deleted!");
    }
    
}
