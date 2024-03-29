public class Employee extends User{
    String position;
    double salary;
    int daysAttend;
    Employee(){

    }
    public Employee(String firstName, String lastName, int age,int id, boolean married){
        super(firstName, lastName, age, id, married);
    }

    public Employee(String firstName, String lastName, int age,int id, boolean married, String position, double salary, int daysAttend) {
        this(firstName, lastName, age, id, married);
        this.position = position;
        this.salary = salary;
        this.daysAttend = daysAttend;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDaysAbsent() {
        return daysAttend;
    }

    public void setDaysAbsent(int daysAttend) {
        this.daysAttend = daysAttend;
    }

    public void attend(){
        this.daysAttend++;
    }
    public void updatePosition(){
        this.position = "Manager";
    }
    public double calculateSalary(){
        return this.salary * daysAttend / 26f;
    }

    public void displayUser(){
        System.out.printf("""
                
                ID: %d
                First name: %s
                Second Name: %s
                Age: %d
                Position: %s
                Salary: %f
                Days attend: %d
                Expected Salary: %f
                
                """,this.getId(), super.getFirstName(), super.getLastName(),super.getAge(),this.position, this.salary, this.daysAttend, this.calculateSalary());
    }
}
