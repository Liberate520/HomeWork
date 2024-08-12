package homeWork;
import java.io.IOException;
import java.time.LocalDate;

import homeWork.Human.Gender;
import homeWork.Human.Human;
import homeWork.Tree.FamilyTree;


public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();


        Human john = new Human("john", Gender.Male, LocalDate.of(1990, 1, 18));
        Human jane = new Human("Jane",  Gender.Female, LocalDate.of(1992, 5, 21));
        Human alice = new Human("Alice",  Gender.Female, LocalDate.of(1985, 8, 3));



        tree.addHuman(john);
        tree.addHuman(jane);
        tree.addHuman(alice);


        Human bob = new Human("Bob", Gender.Male, LocalDate.of(1978, 12, 8), LocalDate.of(2011, 4, 12), alice, john);
        Human charlie = new Human("Charlie",  Gender.Male, LocalDate.of(2000, 5, 6));

        tree.addHuman(bob);
        tree.addHuman(charlie);
//        tree.removeHuman(j);
        john.addChild(bob);  // Добавляем Bob в дети к john
        alice.addChild(bob);


        System.out.println(tree.getFamilyTree());
        tree.sortByName();
        // tree.sortByAge();
        System.out.println(tree.getFamilyTree());

    //     FileHandler fileHandler = new FileHandler();
    //     String fileName = "familyTree.java";


    //    try {
    //        fileHandler.writeToFile(tree, fileName);
    //        System.out.println("Family tree сохранён в файл.");
    //    } catch (IOException e) {
    //        System.out.println("Ошибка сохранения family tree: " + e.getMessage());
    //    }


    //     try {
    //         FamilyTree loadedTree = fileHandler.readFromFile(fileName);
    //         System.out.println("Family tree загружен из файла:");
    //         System.out.println(loadedTree);
    //     } catch (IOException | ClassNotFoundException e) {
    //         System.out.println("Ошибка загрузки family tree: " + e.getMessage());
    //     }





    }
}