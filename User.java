public class User {
    String firstName;
    String lastName;
    int age;
    int id;
    boolean married;

    public User() {

    }

    public User(String firstName, String lastName, int age, int id, boolean married) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
        this.married = married;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
    public void displayUser(){
        System.out.printf("""
                First Name: %s
                Last Name: %s
                Age: %d
                Married: %b
                """,this.getFirstName(), this.getLastName(), this.getAge(), this.isMarried());
    }
}
