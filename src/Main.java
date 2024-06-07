import family_tree.FamilyTree;
import human.FileHandler;
import human.Gender;
import human.Human;
import writer.Writable;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\Users\\User\\Desktop\\GB\\3_Course_OOP\\OOP_Seminars\\homework_1\\homeWork\\src\\tree.txt";

        FamilyTree<Human> tree = testTree();
//        FamilyTree tree = load(filePath);
        System.out.println(tree);

        save(tree, filePath);
    }

    private static FamilyTree<Human> load(String filePath) {
        Writable writable = new FileHandler();
        return (FamilyTree<Human>) writable.read(filePath);
    }

    private static void save(FamilyTree<Human> tree, String filePath) {
        Writable writable = new FileHandler();
        writable.save(tree, filePath);
    }

    private static FamilyTree<Human> testTree() {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1960, 5, 13));
        Human irina = new Human("Ирина", Gender.Female, LocalDate.of(1962, 8, 25));

        tree.add(ivan);
        tree.add(irina);
        tree.setWedding(ivan.getId(), irina.getId());

        Human julia = new Human("Юлия", Gender.Female, LocalDate.of(1987, 2, 2 ), ivan, irina);
        Human daniil = new Human("Даниил", Gender.Male, LocalDate.of(1991, 6, 18 ), ivan, irina);

        tree.add(julia);
        tree.add(daniil);

        Human grandMother = new Human("Зинаида", Gender.Female, LocalDate.of(1940, 9, 10));
        grandMother.addChild(ivan);

        tree.add(grandMother);

//        System.out.println(tree);

//        tree.sortByBirthDate();
        tree.sortByName();
        return tree;
    }
}