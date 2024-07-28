package FamilyTree;

import FamilyTree.human.*;
import FamilyTree.familyTree.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем родителей
        Human father = new Human("Иван", LocalDate.of(1981, 5, 1), null, Gender.Male, "Инженер", "Русский", "Херсон", null, null);
        Human mother = new Human("Наталья", LocalDate.of(1983, 6, 12), null, Gender.Female, "Доктор", "Украинка", "Херсон", null, null);

        // Устанавливаем супругов
        father.setSpouse(mother);
        mother.setSpouse(father);

        // Создаем детей
        Human[] children = new Human[]{
                new Human("Анастасия", LocalDate.of(2009, 4, 26), null, Gender.Female, "Ученица", "Русская", "Херсон", father, mother),
                new Human("Иван", LocalDate.of(2024, 5, 1), null, Gender.Male, null, "Русский", "Сургут", father, mother),
                new Human("Виктор", LocalDate.of(2024, 5, 1), null, Gender.Male, null, "Русский", "Сургут", father, mother)
        };

        // Добавляем детей к родителям
        for (Human child : children) {
            father.addChild(child);
            mother.addChild(child);
        }

        // Создаем дерево семьи
        FamilyTree familyTree = new FamilyTree();

        // Добавляем членов семьи к дереву
        Human[] familyMembers = new Human[]{father, mother, children[0], children[1], children[2]};
        for (Human member : familyMembers) {
            familyTree.addMember(member);
        }

        // Работаем с древом

        System.out.println(father.getInfo());
        System.out.println(mother.getInfo());
        System.out.println(children[0].getInfo());
        System.out.println(children[1].getInfo());
        System.out.println(children[2].getInfo());

        System.out.println();

        List<Human> childrenOfIvan = familyTree.getChildren(father);
        System.out.println("Дети Ивана: ");
        for (Human child : childrenOfIvan) {
            System.out.println(child.getName());
        }

        System.out.println();

        List<Human> siblingsOfAnastasia = familyTree.getSiblings(children[0]);
        System.out.println("Братья и сестры Анастасии: ");
        for (Human sibling : siblingsOfAnastasia) {
            System.out.println(sibling.getName());
        }

        System.out.println();

        Human spouseOfIvan = familyTree.getSpouse(father);
        System.out.println("Супруга Ивана: " + (spouseOfIvan != null ? spouseOfIvan.getName() : "Отсутсвует"));

        System.out.println();

        List<Human> ancestorsOfIvanAndViktor = familyTree.getAncestors(children[1]);
        System.out.println("Предки Ивана и Виктора:");
        for (Human ancestor : ancestorsOfIvanAndViktor) {
            System.out.println(ancestor.getName() + " (" + ancestor.getYearsString(ancestor.getAge()) + ")");
        }
    }
}