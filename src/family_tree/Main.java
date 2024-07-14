package family_tree;


import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human natalya = new Human("Наталья", LocalDate.of(1964, 9, 19), Gender.женский);
        Human ivan = new Human("Иван", LocalDate.of(1967, 1, 16), Gender.мужской);
        Human olga = new Human("Ольга", LocalDate.of(1989, 3, 20), Gender.женский);
        Human elena = new Human("Елена", LocalDate.of(1994, 12, 23), Gender.женский);

        familyTree.addHuman(natalya);
        familyTree.addHuman(ivan);
        familyTree.addHuman(olga);
        familyTree.addHuman(elena);

        familyTree.addParentChildRelation("Наталья", "Ольга");
        familyTree.addParentChildRelation("Наталья", "Елена");
        familyTree.addParentChildRelation("Иван", "Ольга");
        familyTree.addParentChildRelation("Иван", "Елена");

        List<Human> childrenOfNatalya = familyTree.getChildrenOf("Наталья");
        System.out.println("Дети Натальи:");
        for (Human child : childrenOfNatalya) {
            System.out.println(child.getName() + " (Дата рождения: " + child.getBirthDate() + ")");
        }

        List<Human> childrenOfIvan = familyTree.getChildrenOf("Иван");
        System.out.println("Дети Ивана:");
        for (Human child : childrenOfIvan) {
            System.out.println(child.getName() + " (Дата рождения: " + child.getBirthDate() + ")");
        }

        System.out.println(familyTree);
    }

}
