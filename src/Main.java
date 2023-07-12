import Serializable.FileHandler;
import familyTree.FamilyTree;
import human.Gender;
import human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        FileHandler fileHandler = new FileHandler();
//
//        FamilyTree tree = new FamilyTree();
//
//        tree.addHuman(new Human("�������", "C", "�", Gender.Male, LocalDate.of(1949, 4, 4),
//                LocalDate.of(1986, 7, 8)));
//        tree.addHuman(new Human("���������", "�", "�", Gender.Female, LocalDate.of(1949, 9,9)));
//        tree.addHuman(new Human("�������", "�", "�", Gender.Male, LocalDate.of(1980, 6, 7),
//                tree.getByName("�������", "C", "�"), tree.getByName("���������", "�", "�")));
//        tree.addHuman(new Human("��������", "�", "�", Gender.Female, LocalDate.of(1986, 4, 10)));
//        tree.addHuman(new Human("��������", "�", "�", Gender.Female, LocalDate.of(2010, 2, 20),
//                tree.getByName("�������", "�", "�"), tree.getByName("��������", "�", "�")));
//        tree.addHuman(new Human("�������", "�", "�", Gender.Male, LocalDate.of(2014, 2, 2),
//                tree.getByName("�������", "�", "�"), tree.getByName("��������", "�", "�")));
//
//        System.out.println(tree.getFamilyTreeInfo());
//
//        fileHandler.save(tree, "src/Serializable/tree.out");

        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read("src/Serializable/tree.out");
        System.out.println(tree.getFamilyTreeInfo());
    }
}
