import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.Gender;
import ru.gb.family_tree.Human;
import ru.gb.family_tree.writer.FileHendler;

import java.time.LocalDate;
import java.util.List;

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
        Human petr = new Human("Филимонов", "Перт", LocalDate.of(2010, 11,19), Gender.мужской, masha, sergey);
        petr.setPatronymic("Сергеевич");
        tree.add(petr);
        tree.add(kate);

        Human babaKate = new Human("Матосова", "Катя", LocalDate.of(1962, 9,11), Gender.женский);
        sergey.setPatronymic("Павловна");
        tree.add(babaKate);
        sergey.setMother(babaKate);
        Human dedSergey = new Human("Матосов", "Сергей", LocalDate.of(1959, 9,18), Gender.мужской);
        sergey.setPatronymic("Владимирович");
        tree.add(dedSergey);
        sergey.setFather(dedSergey);

        System.out.println(tree);


        List<Human> findHuman = tree.findByName("Катя");
        System.out.println("Найдено "+ findHuman.size()+ ": ");
        for (Human h: findHuman){
           System.out.println(h);
        }


        FileHendler fileHendler;
        fileHendler = new FileHendler(tree);


        fileHendler.serializationToFile();


       List<Human> humans = fileHendler.restoringFromFile();

        System.out.println("Восстановленные из файла люди, количество: "+ humans.size());



    }
}
