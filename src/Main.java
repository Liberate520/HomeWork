import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human oleg = new Human("Олег", Gender.Male, LocalDate.of(1955, 1, 1));
        Human tamara = new Human("Тамара", Gender.Female, LocalDate.of(1953, 9, 11), LocalDate.of(2021, 5, 15), null, null);

        tree.add(oleg);
        tree.add(tamara);
        tree.setWedding(oleg.getId(), tamara.getId());

        Human aleksandr = new Human("Александр", Gender.Male, LocalDate.of(1986, 10, 16), oleg, tamara);

        tree.add(aleksandr);

        Human grandFather = new Human("Петр", Gender.Male, LocalDate.of(1928, 3, 15), LocalDate.of(1991, 2, 8), null, null);
        Human grandMother = new Human("Анна", Gender.Female, LocalDate.of(1932, 12, 19), LocalDate.of(1994, 11, 6), null, null);
        grandFather.addChildren(tamara);
        grandMother.addChildren(tamara);

        tree.add(grandFather);
        tree.add(grandMother);
        tree.setWedding(grandFather.getId(), grandMother.getId());

        System.out.println(tree);
    }
}