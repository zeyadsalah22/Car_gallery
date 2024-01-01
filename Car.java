public class Car {
    private String brand;
    private String model;
    private double price;
    public Car(String brand,String model,double price){
        this.brand = brand;
        this.model = model;
        this.price = price;
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

    public void displayCar(){
        System.out.println("Car's brand: "+this.brand+", model: "+this.model+" and price:"+this.price);
    }

}
