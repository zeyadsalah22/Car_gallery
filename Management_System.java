import java.util.*;
public class Management_System {
    private ArrayList<Employee> staff = new ArrayList<Employee>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Car> goods = new ArrayList<Car>();
    private double budget;

    public Management_System(ArrayList<Employee> staff, ArrayList<Client> clients, ArrayList<Car> goods, double budget) {
        this.staff = staff;
        this.clients = clients;
        this.goods = goods;
        this.budget = budget;
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Employee> staff) {
        this.staff = staff;
    }
    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Car> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Car> goods) {
        this.goods = goods;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    public void displayStaff(){
        System.out.println("Our Staff:");
        for(int i=0;i< staff.size();i++){
            staff.get(i).displayUser();
        }
    }
    public void displayClient(){
        System.out.println("Our Clients:");
        for(int i=0;i< clients.size();i++){
            clients.get(i).displayUser();
        }
    }
    public void displayCar(){
        System.out.println("Our Cars:");
        for(int i=0;i< goods.size();i++){
            goods.get(i).displayCar();
        }
    }
}
