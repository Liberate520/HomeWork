package seminar2;

import seminar2.Human.Gender;
import seminar2.Human.Human;
import seminar2.Service.FileHandler;
import seminar2.Service.Writable;
import seminar2.Tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        FamilyTree tree = new FamilyTree();

        String path = "src/seminar2/output.txt";

        //FamilyTree tree = load(path);

        // ------добавление людей ----------

        Human person1 = new Human("Василий", "Иванов", Gender.Male,
                LocalDate.of(1963,12,10));
        Human person2 = new Human("Марина", "Смирнова", Gender.Female,
                LocalDate.of(1967, 04, 04));


        // ------- добавление людей в дерево
        tree.add(person1);
        tree.add(person2);

        // ------- ЗАГС -----------

        person1.setPartner(person2);
        person2.setPartner(person1);

        // ------ Рождение детей ----
        Human person3 = new Human("Ирина", "Иванова", Gender.valueOf("Female"),
                LocalDate.of(1986, 11, 12), person1, person2);

        tree.add(person3);

        Human person4 = new Human("Василиса", "Иванова", Gender.Female,
                LocalDate.of(1982, 12, 11), person1, person2);

        tree.add(person4);

        Human person5 = new Human("Антонина", "Иванова", Gender.Female,
                LocalDate.of(1943, 03, 11), null, person1);
        Human person6 = new Human("Аркадий", "Васильев", Gender.Male,
                LocalDate.of(1940, 01, 06), LocalDate.of(1991,12,12),
                null, null, null);

        person5.addChild(person1);
        person6.addChild(person1);

        tree.add(person5);
        tree.add(person6);



        Human person7 = new Human("Алёна", "Смирнова", Gender.Female,
                LocalDate.of(1969, 05, 14), null, null);
        Human person8 = new Human("Андрей", "Смирнов", Gender.Male,
                LocalDate.of(1995, 07, 11), null, person7);
        Human person9 = new Human("Анна", "Смирнова", Gender.Female,
                LocalDate.of(1998, 05, 20), null, person7);
        Human person10 = new Human("Агата", "Смирнова", Gender.Female,
                LocalDate.of(2000, 03, 01), null, person7);

        tree.add(person7);
        tree.add(person8);
        tree.add(person9);
        tree.add(person10);
        System.out.println(tree);

        show();
        // ------ поиск по имени и фамилии ----------
        System.out.println(tree.getByNameSurname("Аркадий", "Васильев"));
        show();

        // --------вывод на экран всех членов одной семьи --------
        System.out.println(tree.getByOneFamily("Иванов"));

        System.out.println(tree.getByOneFamily("Смирнова"));


        // ------- метод для записи потока ----------


        save(tree, path);

        // ---------сортировки ---------------

        show();
        tree.sortByName();
        System.out.println(tree);
        show();
        tree.sortBySurname();
        System.out.println(tree);
        show();
        tree.sortByAge();
        System.out.println(tree);
        show();
        tree.sortByChildren();
        System.out.println(tree);

    }

    private static void save(FamilyTree tree, String path) throws IOException {
        Writable file = new FileHandler();
        file.save((Serializable) tree, path);
    }

    private static FamilyTree load(String path) throws IOException, ClassNotFoundException {
        Writable file = new FileHandler();
        return (FamilyTree) file.load(path);
    }


    private static void show(){
        System.out.println("************************************************************");
    }



}
