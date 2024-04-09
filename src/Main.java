import writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();

        Human child1 = new Human("София", LocalDate.of(2000, 5, 12), null, Gender.Female, null, null, null);
        Human child2 = new Human("Андрей", LocalDate.of(1998, 1, 8), null, Gender.Male, null, null, null);

        Human father = new Human("Сергей", LocalDate.of(1968, 4, 22), null, Gender.Male, null, null, null);
        Human mother = new Human("Анна", LocalDate.of(1975, 6, 4), null, Gender.Female, null, null, null);


        child1.setFather(father);
        child2.setFather(father);
        child1.setMother(mother);
        child2.setMother(mother);

//        List<Human> children = new ArrayList<>();
//        children.add(child1);
//        children.add(child2);
//        father.setChildren(children);
//        mother.setChildren(children);
        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child1);

        familyTree.addHuman(child1);
        familyTree.addHuman(child2);
        familyTree.addHuman(father);
        familyTree.addHuman(mother);

        System.out.println(familyTree);
        System.out.println(familyTree.getHumanChildren(mother));

        FileHandler fileHandler = new FileHandler();
        fileHandler.writeExternal(familyTree, "Tree.txt");

    }

}