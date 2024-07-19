import model.*;
import service.FamilyTreeService;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Human mariya = new Human("Mariya", Gender.FEMALE, LocalDate.of(1980, 1, 1));
        Human pyotr = new Human("Pyotr", Gender.MALE, LocalDate.of(1981, 2, 2));
        Human alisa = new Human("Alisa", Gender.FEMALE, LocalDate.of(2005, 3, 3));
        Human vladimir = new Human("Vladimir", Gender.MALE, LocalDate.of(2008, 4, 4));

        FamilyTree<Human> tree = new FamilyTree<>();
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

        // Serialization to file using ObjectOutputStream
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("human.out"))) {
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization from file using ObjectInputStream
        FamilyTree<Human> treeRestored;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.out"))) {
            treeRestored = (FamilyTree<Human>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Family Tree Restored:");
        System.out.println(treeRestored);

        FamilyTreeService<Human> service = new FamilyTreeService<>();
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
