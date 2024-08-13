
import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;
import model.writer.FileHandler;
import view.ConsoleUi;
import view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);

        View view = new ConsoleUi();
        view.start();
//        //saveTree(model.tree);
//        // readTree(model.tree);
//        tree.sortByBirthDate();
//        System.out.println(tree);
//        System.out.println();
//        System.out.println(tree.getByName());
    }

    private static FamilyTree<Human> readTree(FamilyTree<Human> tree) {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree<Human>) fileHandler.read();
    }

    private static void saveTree(FamilyTree tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    private static FamilyTree testTree() {
        FamilyTree<Human> ft = new FamilyTree<Human>();

        Human igor = new Human("Игорь", Gender.Male, LocalDate.of(1985, 10, 2));
        Human katy = new Human("Екатерина", Gender.Female, LocalDate.of(1987, 5, 3));

        ft.add(igor);
        ft.add(katy);
        ft.setWedding(igor, katy);

        Human misha = new Human("Михаил", Gender.Male, LocalDate.of(2006, 3, 1),
                igor, katy);
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(2010, 12, 18),
                igor, katy);

        ft.add(misha);
        ft.add(masha);

        Human grandMother = new Human("Елена", Gender.Female, LocalDate.of(1965, 4, 8));
        grandMother.addChildren(katy);

        ft.add(grandMother);

        return ft;
    }
}