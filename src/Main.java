import human.Gender;
import human.Human;
import tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();

        Human igor = new Human("Игорь", Gender.Male, LocalDate.of(1985, 10, 2));
        Human katy = new Human("Екатерина", Gender.Female, LocalDate.of(1987, 5, 3));

        ft.add(igor);
        ft.add(katy);
        ft.setWedding(igor,katy);

        Human misha = new Human("Михаил", Gender.Male, LocalDate.of(2006, 3, 1),
                igor, katy);
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(2010, 12, 18),
                igor, katy);

        ft.add(misha);
        ft.add(masha);

        Human grandMother = new Human("Елена", Gender.Female, LocalDate.of(1965, 4, 8));
        grandMother.addChildren(katy);

        ft.add(grandMother);

        System.out.println(ft);



    }
}