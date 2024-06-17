import ru.gb.family_tree.family_tree.TreeNode;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.save.FileHandler;
import ru.gb.family_tree.save.Writable;
import ru.gb.family_tree.family_tree.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;

public class Main implements Serializable {
    public static void main (String[] args) {
        String filePath = "src\\ru\\gb\\family_tree\\tree.txt";
        FamilyTree tree = testTree();
//        FamilyTree tree = load(filePath);
        System.out.println(tree);

//        tree.sortByName();
//        System.out.println(tree);
//
//        tree.sortByBirthdate();
//        System.out.println(tree);


//        save(tree, filePath);
    }

    private static FamilyTree load(String filePath) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);
    }

    private static void save(FamilyTree tree, String filePath) {
        Writable writable = new FileHandler();
        writable.save(tree, filePath);
    }


    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

          Human vanya = new Human("Иван", "Золотов", Gender.мужской,
                LocalDate.of(1901, 01, 12));
        Human vasilisa = new Human("Василиса", "Премудрая",
                Gender.женский, LocalDate.of(1903, 11, 02));

        tree.add(vanya);
        tree.add(vasilisa);

        tree.setWedding(vanya.getId(), vasilisa.getId());

        Human petya = new Human("Петр","Золотов",Gender.мужской,
                LocalDate.of(1921, 5, 20), vanya, vasilisa);
        Human irina = new Human("Ирина", "Золотова", Gender.женский,
                LocalDate.of(1923, 2, 4), vanya, vasilisa);

        tree.add(petya);
        tree.add(irina);

        Human ulya = new Human("Урма", "Премудрая", Gender.женский, LocalDate.of(1879, 4, 11));
        ulya.addChild(vasilisa);

        tree.add(ulya);

        return tree;
    }
}
