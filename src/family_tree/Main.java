
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);

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
