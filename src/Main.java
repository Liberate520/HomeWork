import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.Gender;
import ru.gb.family_tree.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();


        Human masha = new Human("Филимонова", "Маша", LocalDate.of(1985, 3,16), Gender.Female);
        Human sergey = new Human("Филимонов", "Сергей", LocalDate.of(1983, 12,11), Gender.Male);
        tree.add(masha);
        tree.add(sergey);
        Human kate = new Human("Филимонова", "Катя", LocalDate.of(2016, 3,11), Gender.Female, masha, sergey);

        tree.add(kate);



        System.out.println(tree);
        System.out.println(kate);

        System.out.println(masha);
        System.out.println(sergey);

    }
}
