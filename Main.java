package homeWork;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human mother = new Human("Anna", LocalDate.of(1975, 5, 15), Gender.Female);
        Human father = new Human("Alexey", LocalDate.of(1970, 10, 25), Gender.Male);

        Human child1 = new Human("Goshka", LocalDate.of(2000, 3, 10), Gender.Female);
        Human child2 = new Human("Grishka", LocalDate.of(2005, 8, 20), Gender.Male);

        child1.setFamily(mother);
        child2.setFamily(father);

        mother.addChild(child1);
        father.addChild(child1);
        father.addChild(child2);
        tree.addTree(mother);
        tree.addTree(father);
        tree.addTree(child1);
        tree.addTree(child2);

        System.out.println(mother.getChildren());
        System.out.println(father.getChildren());
        System.out.println(tree.printTree());
    }
}
