import ru.gb.family_tree.builder.HumanBuilder;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.service.Service;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {





        test1();
        //test2();

        Service service = new Service();
        service.addHuman("Иванова", "Мария", LocalDate.of(1985, 3,16), Gender.женский);
        service.addHuman("Филимонова", "Оксана", LocalDate.of(1975, 3,16), Gender.женский);
        service.addHuman("Филимонова", "Мария", LocalDate.of(2016, 3,16), Gender.женский);
        service.addHuman("Петров", "Игорь", LocalDate.of(2021, 3,16), Gender.мужской);
        service.addHuman("Костенко", "Дарья", LocalDate.of(1985, 3,16), Gender.женский);
        service.addHuman("Павлов", "Илья", LocalDate.of(1977, 3,16), Gender.мужской);
        service.addHuman("Филимонова", "Ольга", LocalDate.of(2023, 3,16), Gender.женский);
        service.addHuman("Алеков", "Максим", LocalDate.of(2003, 3,16), Gender.мужской);

        System.out.println(service.getFamilyTreeInfo());
        service.sortByFirstName();
        System.out.println(service.getFamilyTreeInfo());

        service.sortByAge();
        System.out.println(service.getFamilyTreeInfo());

        service.sortByLastName();
        System.out.println(service.getFamilyTreeInfo());

    }

    private static void test2() {
        FamilyTree tree = new FamilyTree();
//        Human masha = new Human("Филимонова", "Мария", LocalDate.of(1985, 3,16), Gender.женский);
//        masha.setPatronymic("Андреевна");
//        Human sergey = new Human("Филимонов", "Сергей", LocalDate.of(1983, 12,11), Gender.мужской);
//        sergey.setPatronymic("Сергеевич");
//        tree.addHuman(masha);
//        tree.addHuman(sergey);
//
//        tree.setWedding(masha, sergey);
//
//        Human kate = new Human("Филимонова", "Катя", LocalDate.of(2016, 3,11), Gender.женский, masha, sergey);
//        sergey.setPatronymic("Сергеевна");
//        Human petr = new Human("Филимонов", "Перт", LocalDate.of(2010, 11,19), Gender.мужской, masha, sergey);
//        petr.setPatronymic("Сергеевич");
//        tree.addHuman(petr);
//        tree.addHuman(kate);
//
//        Human babaKate = new Human("Матосова", "Катя", LocalDate.of(1962, 9,11), Gender.женский);
//        sergey.setPatronymic("Павловна");
//        tree.addHuman(babaKate);
//        sergey.setMother(babaKate);
//        Human dedSergey = new Human("Матосов", "Сергей", LocalDate.of(1959, 9,18), Gender.мужской);
//        sergey.setPatronymic("Владимирович");
//        tree.addHuman(dedSergey);
//        sergey.setFather(dedSergey);
//
//        System.out.println(tree);
//
//
//        List<Human> findHuman = tree.findByName("Катя");
//        System.out.println("Найдено "+ findHuman.size()+ ": ");
//        for (Human h: findHuman){
//           System.out.println(h);
//        }
//        Service service = new Service();
//
//        System.out.println(service.getFamilyTreeInfo());
//        FileHendler fileHendler = new FileHendler();
//
//
//        fileHendler.serializationToFile(tree);
//
//
//        FamilyTree tree2 = fileHendler.restoringFromFile();
//
//        System.out.println("Восстановленные из файла люди, количество: "+ tree2.getSize());
    }

    private static void test1() {
        HumanBuilder humanBuilder = new HumanBuilder();
        FamilyTree familyTree = new FamilyTree();
        Human masha = humanBuilder.build("Филимонова", "Мария", LocalDate.of(1985, 3,16), Gender.женский);
        masha.setPatronymic("Андреевна");
        Human sergey = humanBuilder.build("Филимонов", "Сергей", LocalDate.of(1983, 12,11), Gender.мужской);
        sergey.setPatronymic("Сергеевич");
        familyTree.addHuman(masha);
        familyTree.addHuman(sergey);

        familyTree.setWedding(masha, sergey);

        Human kate = humanBuilder.build("Филимонова", "Катя", LocalDate.of(2016, 3,11), Gender.женский, masha, sergey);
        sergey.setPatronymic("Сергеевна");
        Human petr = humanBuilder.build("Филимонов", "Перт", LocalDate.of(2010, 11,19), Gender.мужской, masha, sergey);
        petr.setPatronymic("Сергеевич");
        familyTree.addHuman(petr);
        familyTree.addHuman(kate);

        Human babaKate = humanBuilder.build("Матосова", "Катя", LocalDate.of(1962, 9,11), Gender.женский);
        sergey.setPatronymic("Павловна");
        familyTree.addHuman(babaKate);
        sergey.setMother(babaKate);
        Human dedSergey = humanBuilder.build("Матосов", "Сергей", LocalDate.of(1959, 9,18), Gender.мужской);
        sergey.setPatronymic("Владимирович");
        familyTree.addHuman(dedSergey);
        sergey.setFather(dedSergey);
        familyTree.setWedding(babaKate, dedSergey);

        System.out.println(familyTree);
    }
}
