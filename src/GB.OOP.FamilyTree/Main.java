import OOP.Family_Tree.FamilyTree.FamilyTree;
import OOP.Family_Tree.Human.Gender;
import OOP.Family_Tree.Human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();// создали семейное дерево
        Human human1 = new Human("Михаил",
                LocalDate.of(1909,9,11),

                Gender.Mail);
        Human human2 = new Human("Люба",
                LocalDate.of(1910,9,11),
                Gender.Female);
        Human human3 = new Human("Георгий",
                LocalDate.of(1937,5,13),
                Gender.Mail);
        human3.addFather(human1);
        human3.addFather(human2);
        Human human4 = new Human("Валерий",
                LocalDate.of(1938,12,14),
                Gender.Mail);
        human4.addFather(human1);
        human4.addFather(human2);

        // вариант добавления без конструктора
//        human1.setName("Михаил");
//        human1.setBirthDate(LocalDate.of(1911,9,11));
//        human1.setDod(LocalDate.of(1942,1,25));
//        human1.setPlace(BirthPlace.SaintPeterburg);
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);

        System.out.println(familyTree); // выводим на консоль семейное дерево
        System.out.println(familyTree.getHumanName("Георгий")); // результат поиска по имени

    }
}

