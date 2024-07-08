package FamilyTree;

import java.time.LocalDate;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Олег Олегович", Gender.male, LocalDate.of(1986, 01, 17), LocalDate.of(2021, 12, 15));
        Human human2 = new Human("Петр Петрович", Gender.male, LocalDate.of(2005, 02, 17));
        Human human3 = new Human("Семен Семенович", Gender.male, LocalDate.of(1955, 03, 17), LocalDate.of(2000, 12, 14));
        Human human4 = new Human("Василиса Петровна", Gender.female, LocalDate.of(1985, 04, 17));
        Human human5 = new Human("Олег Викторович", Gender.male, LocalDate.of(1999, 05, 17));
        Human human6 = new Human("Ольга Семеновна", Gender.female, LocalDate.of(2020, 06, 17));
        Human human7 = new Human("Сара Абрамовна", Gender.female, LocalDate.of(1988, 07, 17));
        Human human8 = new Human("Александр Викторович", Gender.male, LocalDate.of(1997, 12, 17));

        human1.addChildren(human8);
        human8.addParent(human1);
        human1.addChildren(human3);
        human3.addParent(human1);
        human5.addChildren(human2);
        human2.addParent(human5);
        human3.addChildren(human5);
        human5.addParent(human3);
        human3.addChildren(human6);
        human6.addParent(human3);
        human8.addChildren(human7);
        human7.addParent(human8);
        human7.addChildren(human4);
        human4.addParent(human7);

        familyTree.createTree(human1);
        System.out.println(familyTree.getTree());
    }
}