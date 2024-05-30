import java.time.LocalDate;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.saving_data.FileHandler;
import ru.gb.family_tree.saving_data.Writable;
import ru.gb.family_tree.tree.FamilyTree;

public class Main {
    public static void main(String[] args) throws Exception {

        FamilyTree tree = new FamilyTree();

        String storage = "family_tree.out";

        Writable writable = new FileHandler(tree);

        // tree = writable.read_object(storage);
        // System.out.println("После чтения из файла:\n\n" + tree);

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 11));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 29));
        Human cristina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 6, 5));
        Human semyon = new Human("Семён", Gender.Male, LocalDate.of(1991, 1, 12));

        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya.getId(), masha.getId());
        tree.add(cristina);
        tree.add(semyon);

        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 5));
        grandMother.addChild(vasya);
        tree.add(grandMother);

        Human grandGrandFather = new Human("Фёдор", Gender.Male, LocalDate.of(1915, 3, 15));
        grandGrandFather.addChild(grandMother);
        tree.add(grandGrandFather);

        writable.write_object(tree, storage);

        tree = writable.read_object(storage);

        tree.sortByAge();
        System.out.println("ПРОВЕРКА СОРТИРОВКИ ПО ВОЗРАСТУ\n");
        System.out.println(tree);

        tree.sortByName();
        System.out.println("ПРОВЕРКА СОРТИРОВКИ ПО ИМЕНИ\n");
        System.out.println(tree);

        tree.sortBySpouse();
        System.out.println("ПРОВЕРКА СОРТИРОВКИ ПО СЕМЕЙНОМУ ПОЛОЖЕНИЮ\n");
        System.out.println(tree);

    }
}
