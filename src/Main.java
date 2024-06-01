
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree newTree = new FamilyTree();

        Human vasiliy = new Human("Василий", "Кройтор",
                LocalDate.of(1955, 8, 5), Gender.Male);
        Human tamara = new Human("Тамара", "Кройтор",
                LocalDate.of(1957, 1, 6), Gender.Female);

        newTree.add(vasiliy);
        newTree.add(tamara);

        Human andrej = new Human("Андрей", "Кройтор",
                LocalDate.of(1984, 5, 5), Gender.Male);

        newTree.add(andrej);

        System.out.println(newTree);
    }
}
}
