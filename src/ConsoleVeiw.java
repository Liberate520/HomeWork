import java.util.Scanner;

public class ConsoleVeiw {
    Scanner in = new Scanner(System.in);

    public String get() {
        return in.next();
    };

    public String tName() {
        System.out.printf("Name: ");
        return in.nextLine();
    }
}
