import Human.Human;
import familyTree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree familyTree = new FamilyTree();

        Human progenitor = new Human("GreatDaddy", LocalDate.of(1910,10,10),
                Gender.male, LocalDate.of(1941,11,11));
        Human child_1 = new Human("Bobby", LocalDate.of(1930,8,12), Gender.male);
        Human child_2 = new Human("Alice", LocalDate.of(1934,4,19), Gender.female);

        progenitor.addChild(child_1);
        progenitor.addChild(child_2);

        familyTree.addPerson(progenitor);
        familyTree.addPerson(child_1);
        familyTree.addPerson(child_2);

        child_1.setFather(progenitor);
        child_2.setFather(progenitor);

        //System.out.println(familyTree.getPerson("Alice").getFather());

        //System.out.println(familyTree.getPerson("GreatDaddy").getChildren());

        //System.out.println(familyTree.getPerson("GreatDaddy"));

        //System.out.println(familyTree);

//        handler.FileHandler fileHandler = new handler.FileHandler();
//        fileHandler.WriteObject(familyTree, "1st write");
//
//        familyTree.FamilyTree restoredTree = new familyTree.FamilyTree();
//        restoredTree = fileHandler.ReadObject("1st write");
//
//        System.out.println(restoredTree);


        System.out.println("Исходыный список:");
        for (Human human : familyTree){
            System.out.println(human);
        }

        familyTree.sortByName();

        System.out.println("Сортировка по имени:");
        for (Human human : familyTree){
            System.out.println(human);
        }

        familyTree.sortByAge();

        System.out.println("Сортировка по возрасту:");
        for (Human human : familyTree){
            System.out.println(human);
        }
    }
}