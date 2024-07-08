import ru.gb.family_tree.FileHandler;
import ru.gb.family_tree.Writable;
import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.humen.Gender;
import ru.gb.family_tree.humen.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/ru/gb/family_tree/tree.txt";
        FamilyTree tree = testTree();
        // FamilyTree tree = load(filePath);
        tree.sortByName();
        System.out.println(tree);

        save(tree, filePath);
    }

    public static FamilyTree load(String filePath){
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);
    }

    private static void save(FamilyTree tree, String filePath){
        Writable writable = new FileHandler();
        writable.save((Serializable) tree, filePath);
    }

    private static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human harry = new Human("Harry", Gender.Male, LocalDate.of(1967,7,6));
        Human ann = new Human("Ann", Gender.Female, LocalDate.of(1967,11,19));

        tree.add(harry);
        tree.add(ann);
        tree.setWedding(harry.getId(), ann.getId());

        Human mikhail = new Human("Mikhail", Gender.Male, LocalDate.of(1995,12,31),harry,ann);
        Human roman = new Human("Roman", Gender.Male, LocalDate.of(1998,8,29),harry,ann);

        tree.add(mikhail);
        tree.add(roman);

        Human grandMother = new Human("Larisa", Gender.Female, LocalDate.of(1945,9,6));
        grandMother.addChild(harry);

        tree.add(grandMother);

        return tree;
    }
}