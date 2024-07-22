package family_tree;

import java.time.LocalDate;

/**
 * Main class to test the FamilyTree implementation.
 */
public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }

    /**
     * Creates a test FamilyTree with sample data.
     *
     * @return a FamilyTree with sample data
     */
    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vadim = new Human("Вадим", Gender.Male, LocalDate.of(1981, 5, 29));
        Human nuriya = new Human("Нурия", Gender.Female, LocalDate.of(1981, 3, 17));
        tree.add(vadim);
        tree.add(nuriya);
        tree.setWedding(vadim, nuriya);

        Human yaroslav = new Human("Ярослав", Gender.Male, LocalDate.of(2006, 4, 7), vadim, nuriya);
        Human evgenii = new Human("Евгений", Gender.Male, LocalDate.of(2017, 11, 16), vadim, nuriya);
        tree.add(yaroslav);
        tree.add(evgenii);

        Human grandMother = new Human("Залия", Gender.Female, LocalDate.of(1960, 3, 18));
        grandMother.addChild(vadim);
        tree.add(grandMother);

        return tree;
    }
}
