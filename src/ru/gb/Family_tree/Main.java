import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Family_tree tree = new Family_tree();

        Human irina = new Human("Ирина", Gender.Female, LocalDate.of(1996, 10, 7));
        Human vladimir = new Human("Владимир", Gender.Male, LocalDate.of(1989, 11, 18));

        tree.add(irina);
        tree.add(vladimir);
        tree.setWedding(irina.getId(), vladimir.getId());

        Human eva = new Human("Ева", Gender.Female, LocalDate.of(2023, 6, 15), vladimir, irina);
        Human sergey = new Human("Сергей", Gender.Male, LocalDate.of(2018, 6, 26), vladimir, irina);

        tree.add(eva);
        tree.add(sergey);
    }
}

