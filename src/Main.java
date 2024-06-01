
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree newTree = new FamilyTree();

        Human Vasiliy = new Human("Василий", "Кройтор",
                LocalDate.of(1955, 8, 5), Gender.male);
        Human Tamara = new Human("Тамара", "Кройтор",
                LocalDate.of(1957, 1, 6), Gender.female);

        newTree.add(Vasiliy);
        newTree.add(Tamara);

        Human Andrej = new Human("Андрей", "Кройтор",
                LocalDate.of(1984, 5, 5), Gender.male);

        newTree.add(Andrej);

        System.out.println(newTree);
    }
}
}
