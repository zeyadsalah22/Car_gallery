import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Welcome!");
        boolean program = true;
        while(program){
            System.out.println("""
                    1) add user
                    2) display all users
                    3) update user
                    4) delete user
                    or press anything to exit
                    """);
            String text = sc.nextLine();
            if(text.length() > 1)
                break;
            switch(text.charAt(0)) {
                case '1':
                    Management_System.addUser();
                case '2':
                    Management_System.displayUsers();
                case '3':
                    Management_System.updateUser();
                case '4':
                    Management_System.deleteUser();
                default:
                    program = false;
                    break;
            }

        }
    }
}
