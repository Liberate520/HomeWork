import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.Gender;
import ru.gb.family_tree.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human vanya = new Human("Иван", "Золотов", Gender.мужской, LocalDate.of(1901, 01, 12));
        Human vasilisa = new Human("Василиса", "Премудрая", Gender.женский, LocalDate.of(1903, 11, 02));


        System.out.println(vanya);
        System.out.println(vasilisa);




    }
}
