package family_tree;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.humanTree.HumanTree;
import family_tree.model.service.Service;
import family_tree.view.ConsoleUI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();

//        HumanTree humanTree = new HumanTree();
//
//        Human human1 = new Human("Tom", "Shelby", LocalDate.of(1935, 5, 27), LocalDate.of(2020, 12, 21), Gender.male, null, null, new ArrayList<>());
//        Human human2 = new Human("Anna", "Johnson", LocalDate.of(1940, 7, 20), LocalDate.of(2024, 10, 8), Gender.female, null, null, new ArrayList<>());
//        Human human3 = new Human("Chris", "Shelby", LocalDate.of(1960, 2, 15), null, Gender.male, human1, human2, new ArrayList<>());
//        Human human4 = new Human("Barbara", "Shelby", LocalDate.of(1965, 4, 6), null, Gender.female, human1, human2, new ArrayList<>());
//        Human human5 = new Human("Isaac", "Shelby", LocalDate.of(1988, 1, 3), null, Gender.male, human3, null, new ArrayList<>());
//        Human human6 = new Human("Unnamed", "Shelby", LocalDate.of(1910, 1, 3), null, Gender.male, human3, null, new ArrayList<>());
//
//        humanTree.addHuman(human1); // добавление людей
//        humanTree.addHuman(human2);
//        humanTree.addHuman(human3);
//        humanTree.addHuman(human4);
//        humanTree.addHuman(human5);
//        humanTree.addHuman(human6);
//
//        human1.addChild(human3); // добавление детей к родителям
//        human1.addChild(human4);
//        human2.addChild(human3);
//        human2.addChild(human4);
//        human3.addChild(human5);

//        System.out.println(family_tree.model.humanTree.getInfoAboutChildren(human5));
//        System.out.println(family_tree.model.humanTree.getInfoAboutParents(human3));

//        FileHandler fileHandler = new FileHandler();
//
////        fileHandler.save(family_tree.model.humanTree);
//        HumanTree readedTree = (HumanTree) fileHandler.read();
//        System.out.println(readedTree);


    }
}



