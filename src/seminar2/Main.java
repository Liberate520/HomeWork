package seminar2;

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

        tree.add(person1);
        tree.add(person2);

        Human person3 = new Human("Ирина", "Иванова", Gender.valueOf("Female"),
                LocalDate.of(1986, 11, 12), person1, person2);

        tree.add(person3);

        Human person4 = new Human("Василиса", "Иванова", Gender.Female,
                LocalDate.of(1982, 12, 11), person1, person2);

        tree.add(person4);

        Human person5 = new Human("Антонина", "Иванова", Gender.Female,
                LocalDate.of(1943, 03, 11));
        Human person6 = new Human("Аркадий", "Смирнов", Gender.Male,
                LocalDate.of(1940, 01, 06), LocalDate.of(1991,12,12),
                null, null);

        person5.addChild(person1);
        person6.addChild(person1);

        tree.add(person5);
        tree.add(person6);

        System.out.println(tree);
        System.out.println(tree.getByNameSurname("Аркадий", "Смирнов"));

        // ------- метод для записи потока ----------


        save(tree, path);

    }

    private static void save(FamilyTree tree, String path) throws IOException {
        Writable file = new FileHandler();
        file.save((Serializable) tree, path);
    }

    private static FamilyTree load(String path) throws IOException, ClassNotFoundException {
        Writable file = new FileHandler();
        return (FamilyTree) file.load(path);
    }



}
