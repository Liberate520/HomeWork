package FamilyTree;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("Иван", LocalDate.of(1981, 5, 1), null, Gender.Male, null, null);
        Human mother = new Human("Наталья", LocalDate.of(1983, 6, 12), null, Gender.Female, null, null);

        father.setSpouse(mother);

        Human child1 = new Human("Анастасия", LocalDate.of(2009, 4, 26), null, Gender.Female, father, mother);
        Human child2 = new Human("Иван", LocalDate.of(2024, 5, 1), null, Gender.Male, father, mother);
        Human child3 = new Human("Виктор", LocalDate.of(2024, 5, 1), null, Gender.Male, father, mother);

        father.addChild(child1);
        father.addChild(child2);
        father.addChild(child3);

        mother.addChild(child1);
        mother.addChild(child2);
        mother.addChild(child3);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);
        familyTree.addMember(child3);

        List<Human> childrenOfIvan = familyTree.getChildren(father);

        System.out.println("Дети Ивана: ");
        for (Human child : childrenOfIvan) {
            System.out.println(child.getName());
        }

        List<Human> siblingsOfAnastasia = familyTree.getSiblings(child1);

        System.out.println("Братья и сестры Анастасии: ");
        for (Human sibling : siblingsOfAnastasia) {
            System.out.println(sibling.getName());
        }

        Human spouseOfIvan = familyTree.getSpouse(father);
        System.out.println("Супруга Ивана: " + (spouseOfIvan != null ? spouseOfIvan.getName() : "Отсутсвует"));

        List<Human> ancestorsOfIvan = familyTree.getAncestors(child2);
        System.out.println("Предки Ивана и Виктора:");
        for (Human ancestor : ancestorsOfIvan) {
            System.out.println(ancestor.getName());
        }
    }
}