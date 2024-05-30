package FamilyThreeOOP;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human oxana = new Human("Оксана", Gender.Female, LocalDate.of(1978, 9, 20));
        Human alexey = new Human("Алексей", Gender.Male, LocalDate.of(1975,9,10));
        tree.add(oxana);
        tree.add(alexey);
        tree.setWedding(oxana.getId(), alexey.getId());


        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1998, 9, 9), oxana, alexey);
        Human sofie = new Human("София", Gender.Female, LocalDate.of(2009, 7, 20));
        tree.add(ivan);
        tree.add(sofie);
        System.out.println(tree);
    }

    private static void save(FamilyTree tree, String fileName){
        Rewritable rewritable = new FileHandler();
        rewritable.saveToFile((Serializable) tree, fileName);
    }

    private static FamilyTree load(String fileName){
        Rewritable rewritable = new FileHandler();
        return (FamilyTree) rewritable.loadFromFile(fileName);
    }
}

