import model.FamilyTree;
import model.Gender;
import model.Human;
import service.FamilyTreeService;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Human mariya = new Human("Mariya", Gender.FEMALE, LocalDate.of(1980, 1, 1));
        Human pyotr = new Human("Pyotr", Gender.MALE, LocalDate.of(1981, 2, 2));
        Human alisa = new Human("Alisa", Gender.FEMALE, LocalDate.of(2005, 3, 3));
        Human vladimir = new Human("Vladimir", Gender.MALE, LocalDate.of(2008, 4, 4));

        FamilyTree tree = new FamilyTree();
        tree.addMember(mariya);
        tree.addMember(pyotr);
        tree.addMember(alisa);
        tree.addMember(vladimir);

        pyotr.addChild(alisa);
        pyotr.addChild(vladimir);

        mariya.addChild(alisa);
        mariya.addChild(vladimir);

        System.out.println("Family Tree:");
        System.out.println(tree);

        System.out.println("Children of Pyotr:");
        List<Human> pyotrChildren = tree.getChildrenOf("Pyotr");
        for (Human child : pyotrChildren) {
            System.out.println(child);
        }

        System.out.println("Children of Mariya:");
        List<Human> mariyaChildren = tree.getChildrenOf("Mariya");
        for (Human child : mariyaChildren) {
            System.out.println(child);
        }

        System.out.println("Parents of Alisa:");
        List<Human> alisaParents = tree.getParentsOf("Alisa");
        for (Human parent : alisaParents) {
            System.out.println(parent);
        }

        // Сериализация в файл с помощью класса ObjectOutputStream
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("human.out"))) {
            objectOutputStream.writeObject(mariya);
            objectOutputStream.writeObject(pyotr);
            objectOutputStream.writeObject(alisa);
            objectOutputStream.writeObject(vladimir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Восстановление из файла с помощью класса ObjectInputStream
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.out"))) {
            Human mariyaRestored = (Human) objectInputStream.readObject();
            Human pyotrRestored = (Human) objectInputStream.readObject();
            Human alisaRestored = (Human) objectInputStream.readObject();
            Human vladimirRestored = (Human) objectInputStream.readObject();

            FamilyTree treeRestored = new FamilyTree();
            treeRestored.addMember(mariyaRestored);
            treeRestored.addMember(pyotrRestored);
            treeRestored.addMember(alisaRestored);
            treeRestored.addMember(vladimirRestored);

            pyotrRestored.addChild(alisaRestored);
            pyotrRestored.addChild(vladimirRestored);

            mariyaRestored.addChild(alisaRestored);
            mariyaRestored.addChild(vladimirRestored);

            System.out.println("Family Tree Restored:");
            System.out.println(treeRestored);

            System.out.println("Children of Pyotr Restored:");
            List<Human> pyotrRestoredChildren = treeRestored.getChildrenOf("Pyotr");
            for (Human child : pyotrRestoredChildren) {
                System.out.println(child);
            }

            System.out.println("Children of Mariya Restored:");
            List<Human> mariyaRestoredChildren = treeRestored.getChildrenOf("Mariya");
            for (Human child : mariyaRestoredChildren) {
                System.out.println(child);
            }

            System.out.println("Parents of Alisa Restored:");
            List<Human> alisaRestoredParents = treeRestored.getParentsOf("Alisa");
            for (Human parent : alisaRestoredParents) {
                System.out.println(parent);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        FamilyTreeService service = new FamilyTreeService();
        service.sortByName(tree);
        System.out.println("Sorted by name:");
        for (Human human : tree) {
            System.out.println(human.getName());
        }

        service.sortByBirthDate(tree);
        System.out.println("Sorted by birth date:");
        for (Human human : tree) {
            System.out.println(human.getName() + ": " + human.getBirthDate());
        }
    }
}