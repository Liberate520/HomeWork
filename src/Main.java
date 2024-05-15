import ru.gb.family_tree.Gender;
import ru.gb.family_tree.Human;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("Иван", "Гагарин", Gender.мужской,
                LocalDate.ofEpochDay(1900 - 01 - 01), LocalDate.ofEpochDay(1978 - 03 - 17),
                (Human) null, null, null, null); // начало рода прадед
        Human human2 = new Human("Софья", "Яшина", Gender.женский,
                LocalDate.ofEpochDay(1903 - 05 - 02), LocalDate.ofEpochDay(1980 - 01 - 19),
                null, null, null, human1);

        System.out.println(human1);
        System.out.println(human2);

    }
}
