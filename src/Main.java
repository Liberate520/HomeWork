import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Dmitry",
                "Yermoshin",
                Gender.male,
                new Date(112, 11, 23));
        Human human2 = new Human("Daniil", "Yermoshin", Gender.male, new Date(84, 7, 28));
//        human2.setDod(new Date(175, 11, 15));
        System.out.println(human2);
        human1.setFather(human2);
        System.out.println(human1.getFather());
        System.out.println(human2.getChildren());
    }
}
