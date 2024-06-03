import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human pavel = new Human("Павел", Gender.Male, LocalDate.of(1988, 01, 28));
        Human vera = new Human("Вера", Gender.Female, LocalDate.of(1990, 12, 12));

        tree.addHuman(pavel);
        tree.addHuman(vera);

        pavel.setSpouse(vera);
        vera.setSpouse(pavel);

        Human tima = new Human("Тимофей",Gender.Male, LocalDate.of
                               (2016, 03, 18), pavel, vera);
        tree.addHuman(tima);

        System.out.println(tree.toString());

    }

}
