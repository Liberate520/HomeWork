import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.Gender;
import ru.gb.family_tree.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human vanya = new Human("Иван", "Золотов", Gender.мужской,
                LocalDate.of(1901, 01, 12));

        Human vasilisa = new Human("Василиса", "Премудрая",
                Gender.женский, LocalDate.of(1903, 11, 02));

        tree.add(vanya);
        tree.add(vasilisa);

        tree.setWedding(vanya.getId(), vasilisa.getId());

        Human petya = new Human("Петр","Золотов",Gender.мужской,
                LocalDate.of(1921, 5, 20), vanya, vasilisa);

        Human irina = new Human("Ирина", "Золотова", Gender.женский,
                LocalDate.of(1923, 2, 4), vanya, vasilisa);

        tree.add(petya);
        tree.add(irina);

        Human ulya = new Human("Урма", "Премудрая", Gender.женский, LocalDate.of(1879, 4, 11));
        ulya.addChild(vasilisa);

        tree.add(ulya);

        System.out.println(tree);




    }
}
