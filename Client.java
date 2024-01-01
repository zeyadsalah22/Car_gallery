public class Client extends User{
    private Car car;

    double budget;
    public Client(String firstName, String lastName, int age, int id, boolean married, Car car, double budget) {
        super(firstName, lastName, age, id, married);
        this.car.getCopy(car);
        this.budget = budget;
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
    }
    public void sellCar(){
        if(this.car == null){
            System.out.println("Client doesn't have car!");
            return;
        }
        System.out.println("Car is sold successfully!");
        this.budget += this.car.getPrice();
        this.car = null;
    }

    @Override
    public void displayUser() {
        super.displayUser();
        this.car.displayCar();
    }
}
