import java.util.*;
public class Management_System {
    public static ArrayList<Employee> staff = new ArrayList<>();
    public static ArrayList<Client> clients = new ArrayList<>();
    public static ArrayList<Car> goods = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static double budget;

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
    public static boolean displayStaff(){
        if(staff.isEmpty()){
            System.out.println("No staff information to display");
            return false;
        }
        System.out.println("Our Staff:");
        for (Employee employee : staff) {
            employee.displayUser();
        }
        return true;
    }
    public static boolean displayClient(){
        if(clients.isEmpty()){
            System.out.println("No clients information to display");
            return false;
        }
        System.out.println("Our Clients:");
        for (Client client : clients) {
            client.displayUser();
        }
        return true;
    }
    public static boolean displayCar(){
        if(goods.isEmpty()){
            System.out.println("No cars available");
            return false;
        }
        System.out.println("Our Cars:");
        for (Car good : goods) {
            good.displayCar();
        }
        return true;
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
        boolean married = false;
        String resp;
        do {
            System.out.println("Are you married?\nenter yes or no");
            resp = sc.next();
            resp = resp.toLowerCase();
            switch (resp) {
                case "yes" -> married = true;
                case "no" -> married = false;
                default -> System.out.println("Invalid input!");
            }
        }while(!resp.equals("yes") && !resp.equals("no"));
        if(client)
            return new Client(first, second, age,clients.size() + 1, married);
        else
            return new Employee(first, second, age, staff.size() + 1, married);
    }
    public static void addEmployee(){
        Employee e = (Employee) addUser(false);
        System.out.println("Enter Position (manager / salesperson)");
        String position = sc.next();
        System.out.println("Enter Salary");
        double salary = sc.nextDouble();
        e.setPosition(position);
        e.setSalary(salary);
        staff.add(e);
        message("employee", "added");
    }
    public static void addClient(){
        Client c = (Client) addUser(true);
        System.out.println("Enter budget");
        double budget = sc.nextDouble();
        c.setBudget(budget);
        clients.add(c);
        message("Client", "added");
    }
    public static void addCar(){
        System.out.println("Enter car's brand");
        String brand = sc.next();
        System.out.println("Enter car's model");
        String model = sc.next();
        System.out.println("Enter car's price");
        double price = sc.nextDouble();
        budget-=price;
        Car c = new Car(brand,model,price*(1.1),goods.size()+1);
        goods.add(c);
        message("car", "added");
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
        if(!displayClient())
            return;
        System.out.println("Select the id of the client you want to update");
        int id = sc.nextInt();
        id--;

        if(checkInvalidID(clients.size(), id))
            return;

        clients.get(id).displayUser();
        System.out.println("""
            choose the label you want to change
            1) first name
            2) second name
            3) age
            4) married status
            5) car
            """);
        switch (sc.next().charAt(0)) {
            case '1' -> {
                System.out.println("Enter the first name");
                clients.get(id).setFirstName(sc.next());
            }
            case '2' -> {
                System.out.println("Enter the second name");
                clients.get(id).setLastName(sc.next());
            }
            case '3' -> {
                System.out.println("Enter the age");
                clients.get(id).setAge(sc.nextInt());
            }
            case '4' -> {
                System.out.println("married? 1 for yes, 0 for no");
                clients.get(id).setMarried(sc.nextBoolean());
            }
            case '5' -> {
                System.out.println("Choose the action you want:\n1)Buy car\n2)Sell car");
                switch (sc.next().charAt(0)) {
                    case '1' -> {
                        if(!displayCar())
                            return;
                        System.out.println("Choose the id of the car you want");
                        int carOption = sc.nextInt();
                        carOption--;
                        if (checkInvalidID(goods.size(), carOption))
                            return;
                        clients.get(id).buyCar(goods.get(carOption));
                    }
                    case '2' -> clients.get(id).sellCar();
                }
            }
        }
        message("client", "updated");
    }
    public static void updateEmployee(){
        if(!displayStaff())
            return;
        System.out.println("Select the id of the employee you want to update");
        int id = sc.nextInt();
        id--;
        if(checkInvalidID(staff.size(), id))
            return;

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
        message("employee", "updated");
    }
    public static void updateCar(){
        if(!displayCar())
            return;
        System.out.println("Select the id of the car you want to update");
        int id = sc.nextInt();
        id--;
        if(checkInvalidID(goods.size(), id))
            return;
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
        message("car", "updated");
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
        if(!displayClient())
            return;
        System.out.println("Select the id of the client you want to delete");
        int id = sc.nextInt();
        id--;
        if(checkInvalidID(clients.size(), id))
            return;
        clients.remove(clients.get(id));
        updateIDS(clients);
        message("Client", "deleted");
    }
    public static void deleteEmployee(){
        if(!displayStaff())
            return;
        System.out.println("Select the id of the employee you want to delete");
        int id = sc.nextInt();
        id--;
        if(checkInvalidID(staff.size(), id))
            return;
        staff.remove(staff.get(id));
        updateIDS(staff);
        message("employee", "deleted");
    }
    public static void deleteCar(){
        if(!displayCar())
            return;
        System.out.println("Select the id of the car you want to delete");
        int id = sc.nextInt();
        id--;
        if(checkInvalidID(goods.size(), id))
            return;
        goods.remove(goods.get(id));
        updateIDS(goods);
        message("car", "deleted");
    }

    public static boolean checkInvalidID(int size , int id){
        if(id < 0 || id >= size){
            System.out.println("\nInvalid ID!!\n");
            return true;
        }
        return false;
    }
    public static void message(String what, String operation){
        System.out.printf("""
                ===============================
                the %s has been %s successfully
                ===============================
                """,what, operation);
    }

    public static void updateIDS(ArrayList<?> arr){
        for(int i = 0; i < arr.size(); ++i) {
            if (arr.get(i) instanceof Client)
                ((Client) arr.get(i)).setId(i + 1);
            else if(arr.get(i) instanceof Employee)
                ((Employee)arr.get(i)).setId(i + 1);
            else
                ((Car)arr.get(i)).setId(i + 1);
        }
    }
    
}
