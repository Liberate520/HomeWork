package family_tree;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree newTree = new FamilyTree();

        Human sergey = new Human("Сергей", "Попов",
                LocalDate.of(1976, 4, 6), Sex.male);
        Human julia = new Human("Юлия", "Попова",
                LocalDate.of(1976, 4, 6), Sex.female);

        newTree.add(sergey);
        newTree.add(julia);

        Human liza = new Human("Елизавета", "Попова",
                LocalDate.of(2011, 7, 3), Sex.female, sergey, julia);

        newTree.add(liza);

        System.out.println(newTree);
    }
}
