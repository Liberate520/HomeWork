import family_tree.FamilyTree;
import human.Human;
import human.Sex;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Андрей", LocalDate.of(1975, 1, 1), Sex.MALE);
        Human human2 = new Human("Ирина", LocalDate.of(1972, 12, 28), Sex.FEMALE);
        Human human3 = new Human("Анна", LocalDate.of(1995, 10, 31), Sex.FEMALE,
                human1, human2);
        Human human4 = new Human("Петр", LocalDate.of(1995, 10, 31), Sex.MALE);
        human4.setFamilyTies(human1, human2);
        human2.setDeathDate(LocalDate.of(2014, 1, 20));

        FamilyTree familyTree = new FamilyTree();
        familyTree.add(human1);
        familyTree.add(human2);
        familyTree.add(human3);
        familyTree.add(human4);
        System.out.println(familyTree);
        System.out.println(human1.isSibling(human4));
        System.out.println(human3.isSibling(human4));
        System.out.println(familyTree.printList(human1.getChildren()));

        System.out.println("Сиблинги:");
        System.out.println(familyTree.printList(human3.findSiblings().stream().toList()));

        System.out.println();
        System.out.println("Данные перед сохранением:");
        System.out.println(familyTree);
        FileHandler handler = new FileHandler();
        handler.save(familyTree);
        FamilyTree loadedTree = handler.load();
        System.out.println("Загруженные данные:");
        System.out.println(loadedTree);

        System.out.println();
        System.out.println("Сортировка по имени:");
        familyTree.sortByName();
        System.out.println(familyTree);
        System.out.println("Сортировка по дате рождения:");
        familyTree.sortByBirthDate();
        System.out.println(familyTree);
        System.out.println("Сортировка по возрасту:");
        familyTree.sortByAge();
        System.out.println(familyTree);

    }
}
