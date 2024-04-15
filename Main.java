package homeWork;

import java.time.LocalDate;
import homeWork.human.Human;
import homeWork.service.Service;
import homeWork.gender.Gender;


public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        Human mother = new Human("Anna", LocalDate.of(1975, 5, 15), Gender.Female);
        Human father = new Human("Alexey", LocalDate.of(1970, 10, 25), Gender.Male);

        service.addHuman("sdfsd", LocalDate.of(2024, 10, 25), Gender.Male);
        service.addHuman("Anna", LocalDate.of(2004, 5, 15), Gender.Female, mother, father);
        service.addHuman("Alexey", LocalDate.of(2001, 10, 25), Gender.Male);
        service.addHuman("Asdasd", LocalDate.of(1995, 5, 15), Gender.Female, mother, father);
        service.addHuman("fsdfsdf", LocalDate.of(2000, 10, 25), Gender.Male);
        service.addHuman("sdfsdfs", LocalDate.of(2001, 10, 15), Gender.Female);

        System.out.println(service.getTree());
        service.sortbyName();
        System.out.println(service.getTree());
        service.sortbyDate();
        System.out.println(service.getTree());
    }
}