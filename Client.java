import java.util.ArrayList;
import java.util.Scanner;

public class Client extends User{
    private Car car = null;

    double budget;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    Client(String firstName, String lastName, int age, int id, boolean married){
        super(firstName, lastName, age, id, married);
    }
    public Client(String firstName, String lastName, int age, int id, boolean married, Car car, double budget) {
        this(firstName, lastName, age, id, married);
        this.car.getCopy(car);
        this.budget = budget;
    }
    public boolean hasCar(){
        if(this.car == null){
            System.out.println("No car information is available!!\n");
            return false;
        }
        return true;
    }

    public void buyCar(Car c){
        if(c.getPrice() > this.budget){
            System.out.printf("""
            Not enough money to buy the car
            Needed: %f
            Had: %f
            """,c.getPrice(),this.budget);
            return;
        }
        System.out.println("Car is bought successfully!");
        this.car.getCopy(c);
        this.budget -= car.getPrice();
        Management_System.budget+=c.getPrice();
        Management_System.goods.remove(c);
    }
    public void sellCar(){
        if(!hasCar()) return;
        System.out.println("Car is sold successfully!");
        this.budget += this.car.getPrice();
        Management_System.budget-=this.car.getPrice();
        this.car.setPrice(this.car.getPrice()*1.1);
        Management_System.goods.add(this.car);
        this.car = null;
    }

    @Override
    public void displayUser() {
        System.out.printf("""
            First Name: %s
            Last Name: %s
            Age: %d
            Married: %b
            """,this.getFirstName(), this.getLastName(), this.getAge(), this.isMarried());
        if(!hasCar())
            return;
        this.car.displayCar();
    }
}
