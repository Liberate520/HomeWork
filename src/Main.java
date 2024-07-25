import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.Gender;
import ru.gb.family_tree.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();


        Human masha = new Human("Филимонова", "Мария", LocalDate.of(1985, 3,16), Gender.женский);
        masha.setPatronymic("Андреевна");
        Human sergey = new Human("Филимонов", "Сергей", LocalDate.of(1983, 12,11), Gender.мужской);
        sergey.setPatronymic("Сергеевич");
        tree.add(masha);
        tree.add(sergey);
        tree.setWedding(masha, sergey);
        Human kate = new Human("Филимонова", "Катя", LocalDate.of(2016, 3,11), Gender.женский, masha, sergey);
        sergey.setPatronymic("Сергеевна");
        tree.add(kate);



        System.out.println(tree);


    }
}
