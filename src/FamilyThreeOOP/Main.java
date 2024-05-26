package FamilyThreeOOP;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human oxana = new Human("Оксана", Gender.Female, LocalDate.of(1978, 9, 20));
        Human alexey = new Human("Алексей", Gender.Male, LocalDate.of(1975,9,10));
        tree.add(oxana);
        tree.add(alexey);
        tree.setWedding(oxana.getId(), alexey.getId());
        System.out.println("");

    }
}

