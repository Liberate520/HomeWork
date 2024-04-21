package familly_tree;

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


        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(mikhail);
        familyTree.addHuman(lyudmila);
        familyTree.addHuman(vladimir);
        familyTree.addHuman(ivan);
        familyTree.addHuman(nina);
        familyTree.addHuman(natalya);
        familyTree.addHuman(andrey);


        mikhail.addChild(vladimir);
        lyudmila.addChild(vladimir);
        nina.addChild(natalya);
        ivan.addChild(natalya);
        vladimir.addChild(andrey);
        natalya.addChild(andrey);


        familyTree.printTree();


        FileIO fileIO = new TextFileHandler();
        List<String> dataToWrite = familyTree.convertTreeToText();
        fileIO.writeToFile("family_tree.txt", dataToWrite);


        List<String> dataFromFile = fileIO.readFromFile("family_tree.txt");
        System.out.println("Данные из файла:");
        for (String line : dataFromFile) {
            System.out.println(line);
        }
    }
}