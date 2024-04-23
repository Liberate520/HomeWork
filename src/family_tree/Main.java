package family_tree;

import family_tree.model.Human.Gender;
import family_tree.model.Human.Human;
import family_tree.model.service.Service;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new ConsoleUI();
        view.start();
//        Service service = new Service();
//
//        Human child1 = new Human("София", LocalDate.of(2000, 5, 12), null, Gender.Female, null, null, null);
//        Human child2 = new Human("Андрей", LocalDate.of(1998, 1, 8), null, Gender.Male, null, null, null);
//
//        Human father = new Human("Сергей", LocalDate.of(1968, 4, 22), null, Gender.Male, null, null, null);
//        Human mother = new Human("Анна", LocalDate.of(1975, 6, 4), null, Gender.Female, null, null, null);
//
//
//
//        service.setFather(father,
//                child1);
//        service.setFather(father, child2);
//        service.setMother(mother, child1);
//        service.setMother(mother, child2);
//
//
//        service.addChild(child1, father);
//        service.addChild(child2, father);
//        service.addChild(child1, mother);
//        service.addChild(child1, mother);
//
//        service.addHuman(child1);
//        service.addHuman(child2);
//        service.addHuman(father);
//        service.addHuman(mother);
//
//        System.out.println(service.getHumanListInfo());
//
//        service.sortByName();
//        System.out.println(service.getHumanListInfo());
//
//        service.sortByBirthday();
//        System.out.println(service.getHumanListInfo());


//        FileHandler fileHandler = new FileHandler();
//        fileHandler.writeExternal(familyTree, "Tree.txt");

    }

}