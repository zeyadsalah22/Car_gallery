public class Car {
    private String brand;
    private String model;
    private double price;
    private int id;
    public Car(){}
    public Car(String brand,String model,double price,int id){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void getCopy(Car c2){
        this.brand = c2.brand;
        this.model = c2.model;
        this.price = c2.price;
    }

    public void displayCar() {
        System.out.printf("""
                
                ID: %d
                brand: %s
                model: %s
                price: %f
                
                """,this.getId(), this.getBrand(), this.getModel(), this.getPrice());

    }

}
