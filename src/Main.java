
import View.ConsoleUI;
import View.View;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        work();
        View view = new ConsoleUI();
        view.start();
    }

    public static void work() throws IOException {
//        Human human1 = new Human("Василий", LocalDate.of(1889, 2, 13), Gender.male, Status.dead);
//        human1.setDeathDate(LocalDate.of(1938, 2, 13));
//
//        Human human2 = new Human("Евгения", LocalDate.of(1895, 3, 23), Gender.female, Status.dead);
//        human2.setDeathDate(LocalDate.of(1956, 2, 13));
//
//        Human human3 = new Human("Святослав", LocalDate.of(1929, 11, 3), Gender.male, Status.dead, human1, human2);
//        human3.setDeathDate(LocalDate.of(1987, 2, 13));
////
//        Human human4 = new Human("Елена", LocalDate.of(1894, 12, 21), Gender.female, Status.dead);
//        human4.setDeathDate(LocalDate.of(1955, 2, 13));
//
//        Human human5 = new Human("Михаил", LocalDate.of(1900, 5, 4), Gender.male, Status.dead);
//        human5.setDeathDate(LocalDate.of(1979, 2, 13));

//        Human human6 = new Human("Анна", LocalDate.of(1934, 12, 17), Gender.female, Status.dead);
//        human6.setDeathDate(LocalDate.of(1992, 2, 13));
//
//        Human human7 = new Human("Софья", LocalDate.of(1962, 8, 19), Gender.female, Status.alive);
//        Human human8 = new Human("Эней", LocalDate.of(1932, 10, 2), Gender.male, Status.dead);
//        human8.setDeathDate(LocalDate.of(1988, 2, 13));
//
//        List<Human> children = List.of(human3, human8);
//
//        human3.addParents(human1, human2);
//        human1.setChild(human3);
//        human2.setChild(human3);
//
//        human3.setChild(children);
//
//        human6.addParents(human5, human4);
//        human5.setChild(human6);
//        human4.setChild(human6);
//
//        human7.addParents(human3, human6);
//        human3.setChild(human7);
//        human6.setChild(human8);
//
//        Service service = new Service();
//        service.addHuman("Василий", LocalDate.of(1889, 2, 13), Gender.male, Status.dead, LocalDate.of(1938, 2, 13));
//        service.addHuman("Евгения", LocalDate.of(1895, 3, 23), Gender.female, Status.dead, LocalDate.of(1956, 2, 13));
//        service.addHumanWithParents("Святослав", LocalDate.of(1929, 11, 3),
//                Gender.male, Status.dead, 1, 2, LocalDate.of(1987, 2, 13));
//        service.addHuman("Елена", LocalDate.of(1894, 12, 21), Gender.female, Status.dead, LocalDate.of(1955, 2, 13));
//        service.addHuman("Михаил", LocalDate.of(1900, 5, 4), Gender.male, Status.dead, LocalDate.of(1979, 2, 13));
//
//

//        Service restoredFamilyTree = service.loadInfo();
//
//        System.out.println(restoredFamilyTree.getInfoFamilyTree());
//        System.out.println(familyTree.getInfoFamilyTree());
//        System.out.println(familyTree.getInfoFamilyTree());
//        familyTree.sortByAge();
//        System.out.println(familyTree.getInfoFamilyTree());
//        familyTree.sortByName();
//        System.out.println(familyTree.getInfoFamilyTree());
    }
}
