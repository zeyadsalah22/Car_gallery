import com.sun.security.ntlm.Client;

import java.util.*;
Scanner k = new Scanner(System.in);
public class Management_System {
    private static ArrayList<Employee> staff = new ArrayList<Employee>();
    private static ArrayList<Client> clients = new ArrayList<Client>();
    private static ArrayList<Car> goods = new ArrayList<Car>();
    private static double budget;

    public static void displayStaff(){
        System.out.println("Our Staff:");
        for(int i=0;i< staff.size();i++){
            staff.get(i).displayUser();
        }
    }
    public static void displayClient(){
        System.out.println("Our Clients:");
        for(int i=0;i< clients.size();i++){
            clients.get(i).displayUser();
        }
    }
    public static void displayCar(){
        System.out.println("Our Cars:");
        for(int i=0;i< goods.size();i++){
            goods.get(i).displayCar();
        }
    }
    public static void addUser(){
        System.out.println("Enter e for Employee and c for Clients");
        char x = k.next();
        System.out.println("Enter First Name");
        String first = k.next();
        System.out.println("Enter Second Name");
        String second = k.next();
        System.out.println("Enter Age");
        int age = k.nextInt();
        System.out.println("Are you married?");
        boolean marrried = k.nextBoolean();
        if (x=='e')
            this.addEmployee(first,second,age,marrried);
        else
            this.addClient(first,second,age,marrried);
    }
    public static void addEmployee(String first,String second,int age,boolean marrried){
        System.out.println("Enter Position");
        String position = k.next();
        System.out.println("Enter Salary");
        double salary = k.nextDouble();
        Employee e = new Employee(first,second,age,marrried,position,salary,0,staff.size()+1);
        staff.add(e);
    }
    public static void addClient(String first,String second,int age,boolean marrried){
        System.out.println("Enter budget");
        double budget = k.nextDouble();
        Client c = new Client(first,second,age,clients.size()+1,married,null,budget);
        clients.add(e);
    }
    public static void addCar(){
        System.out.println("Enter car's brand");
        String brand = k.next();
        System.out.println("Enter car's model");
        String model = k.next.model();
        System.out.println("Enter car's price");
        double price = k.nextDouble();
        budget-=price;
        Car c = new Car(brand,model,price*(1.1));
        clients.add(e);
    }
    public static void updateClient();
    public static void updateEmplyee();
    public static void updateCar();
    public static void deletClient();
    public static void deletEmployee();
    public static void deletCar();

}
