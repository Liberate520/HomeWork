import famuly_tree.FamilyTree;
import human.Human;
import human.Sex;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Андрей", LocalDate.of(1975, 1, 1), Sex.MALE);
        Human human2 = new Human("Ирина", LocalDate.of(1976, 12, 28), Sex.FEMALE);
        Human human3 = new Human("Анна", LocalDate.of(1995, 10, 31), Sex.FEMALE,
                human1, human2);
        Human human4 = new Human("Петр", LocalDate.of(1995, 10, 31), Sex.MALE);
        human4.setFamilyTies(human1, human2);

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
    }
}
