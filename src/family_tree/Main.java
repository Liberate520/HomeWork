package family_tree;

import family_tree.io.FileIO;
import family_tree.io.TextFileHandler;
import family_tree.model.FamilyTree;
import family_tree.model.Human;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human mikhail = new Human("Михаил", "Male", "17-03-1953", "07-03-2018");
        Human lyudmila = new Human("Людмила", "Female", "28-02-1955", null);
        Human vladimir = new Human("Владимир", "Male", "07-11-1977", null);
        Human ivan = new Human("Иван", "Male", "26-07-1945", "10-08-2016");
        Human nina = new Human("Нина", "Female", "28-01-1950", null);
        Human natalya = new Human("Наталья", "Female", "25-07-1978", null);
        Human andrey = new Human("Андрей", "Male", "13-09-1998", null);

        FamilyTree<Human> familyTree = new FamilyTree<>();
        familyTree.addBeing(mikhail);
        familyTree.addBeing(lyudmila);
        familyTree.addBeing(vladimir);
        familyTree.addBeing(ivan);
        familyTree.addBeing(nina);
        familyTree.addBeing(natalya);
        familyTree.addBeing(andrey);

        mikhail.addChild(vladimir);
        lyudmila.addChild(vladimir);
        nina.addChild(natalya);
        ivan.addChild(natalya);
        vladimir.addChild(andrey);
        natalya.addChild(andrey);

        familyTree.sortByBirthDate();

        System.out.println("Отсортированный список по дате рождения:");
        for (Human person : familyTree) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }

        FileIO fileIO = new TextFileHandler();
        var dataToWrite = familyTree.convertTreeToText();
        fileIO.writeToFile("family_tree.txt", dataToWrite);
    }
}
