package family_tree;
import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

import static java.nio.file.Files.write;


public class Main {
    final static String filePath = "src/family_tree/writer/tree.txt";

    public static void main(String[]args) {
        FamilyTree tree = load();

        //FamilyTree tree = testTree();

        //save(tree);

        System.out.println(tree);
    }

    public static FamilyTree load() {
        FileHandler fileHandler = new FileHandler(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(familyTree);
    }




    private static void write(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(filePath);
        }


    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human igor = new Human("Игорь", Gender.Male, LocalDate.of(1965, 1, 23));
        Human natasha = new Human("Наталья", Gender.Female, LocalDate.of(1967, 7, 19));

        tree.add(igor);
        tree.add(natasha);
        tree.setWedding(igor, natasha);

        Human alex = new Human("Александр", Gender.Male, LocalDate.of(1985, 8, 1),
                natasha, igor);
        Human boris = new Human("Борис", Gender.Male, LocalDate.of(1987, 4, 25),
                natasha, igor);
        Human olga = new Human("Ольга", Gender.Female, LocalDate.of(1990, 2, 2),
                natasha, igor);
        tree.add(alex);
        tree.add(boris);
        tree.add(olga);

        Human grandMother1 = new Human("Ирина", Gender.Female, LocalDate.of(1940, 3, 8));
        grandMother1.addChild(igor);
        Human grandMother2 = new Human("Полина", Gender.Female, LocalDate.of(1942, 5, 8));
        grandMother2.addChild(natasha);
                tree.add(grandMother1);
        tree.add(grandMother2);

        return tree;

    }
}

