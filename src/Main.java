import Human.Human;
import Human.Gender;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Human dima = new Human("Dmitry",
                "Yermoshin",
                Gender.male,
                LocalDate.of(2012, 12, 23));
        Human daniil = new Human("Daniil", "Yermoshin", Gender.male, LocalDate.of(1984, 8, 28));
        daniil.setChildren(dima);
        dima.addParent(daniil);
        System.out.println(dima.getInfo());
        System.out.println(daniil.getInfo());
        System.out.println(daniil.getChildren());
        Human alina = new Human("Alina",
                "Yermoshina",
                Gender.female,
                LocalDate.of(1986, 10, 8));
        alina.setWending(daniil);
        System.out.println(alina.getInfo());
        System.out.println(daniil.getInfo());
    }
}
