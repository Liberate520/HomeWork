package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/family_tree/writer/tree.txt";
        
        // FamilyTree tree = read(filePath);
        FamilyTree tree = testTree();

        System.out.println(tree);
        save(tree, filePath);
    }

static FamilyTree read(String filePath) {
    FileHandler fileHandler = new FileHandler();
    return (FamilyTree) fileHandler.read(filePath);
}

static void save(FamilyTree familyTree, String filePath) {
    FileHandler fileHandler = new FileHandler();
    fileHandler.save(familyTree, filePath);
}


    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        tree.add(masha);
        tree.add(vasya);
        tree.setWedding(vasya, masha);

        Human chrictina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
                vasya, masha);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
                vasya, masha);
        tree.add(semyon);
        tree.add(chrictina);

        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vasya);
        tree.add(grandMother);

        return tree;
    }

}
