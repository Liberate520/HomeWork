package homeWork;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        FileHandler fileHandler = new FileHandler();

        Human mother = new Human("Anna", LocalDate.of(1975, 5, 15), Gender.Female);
        Human father = new Human("Alexey", LocalDate.of(1970, 10, 25), Gender.Male);
        Human child1 = new Human("Goshka", LocalDate.of(2000, 3, 10), Gender.Female);
        Human child2 = new Human("Grishka", LocalDate.of(2005, 8, 20), Gender.Male);
        Human child3 = new Human("Abc", LocalDate.of(2005, 8, 20), Gender.Male);
        Human chel = new Human("MAxon", LocalDate.of(2005, 8, 20), Gender.Male);


        mother.addChild(child1, mother, father);
        mother.addChild(child2, mother, father);
        child2.addChild(child3, child2, chel);


        tree.addTree(mother);
        tree.addTree(father);
        tree.addTree(child1);
        tree.addTree(child2);
        tree.addTree(child3);
        tree.addTree(chel);


        fileHandler.writeFile(tree, "familyTree.txt");
        FamilyTree tree1 = (FamilyTree) fileHandler.readFile("familyTree.txt");
        System.out.println(tree1.printTree());
    }
}
