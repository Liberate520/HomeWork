import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import service.Service;
import writable.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Service service = testTree();
        Service service = load();

        System.out.println("\n|___________________________|\n");
        System.out.println(service);

//        save(service);

        service.sortByName();
        System.out.println(service);

        service.sortByAge();
        System.out.println(service);

    }




    static Service load() {
        FileHandler fileHandler = new FileHandler();
        return (Service) fileHandler.load();
    }

    static void save(Service service) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(service);
    }

    static Service testTree() {
        Service service = new Service();
        //Родители
        Human ivan = new Human("Иван", LocalDate.of(1940, 7, 28), Gender.Male);
        Human olga = new Human("Ольга", LocalDate.of(1940, 7, 28), Gender.Female);
        service.add(ivan);
        service.add(olga);

        //Дети
        Human alexandr = new Human("Александр", LocalDate.of(1960, 5, 9), Gender.Male);
        Human nadezda = new Human("Надежда", LocalDate.of(1965, 1, 1), Gender.Female);
        service.add(alexandr);
        service.add(nadezda);
        alexandr.addParent(ivan);
        alexandr.addParent(olga);

        //Внуки
        Human alice = new Human("Алиса", LocalDate.of(1985, 3, 8), Gender.Female);
        Human kamila = new Human("Камила", LocalDate.of(1990, 8, 21), Gender.Female);
        service.add(alice);
        service.add(kamila);
        alexandr.addChildren(alice);
        alexandr.addChildren(kamila);
        nadezda.addChildren(alice);
        nadezda.addChildren(kamila);
        return service;
    }
}