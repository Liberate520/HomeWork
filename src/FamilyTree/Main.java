package FamilyTree;

import FamilyTree.human.*;
import FamilyTree.familyTree.*;
import FamilyTree.Writer.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        // Создаем родителей
//        Human father = new Human("Иван", LocalDate.of(1981, 5, 1), null, Gender.Male, "Инженер", "Русский", "Херсон", null, null);
//        Human mother = new Human("Наталья", LocalDate.of(1983, 6, 12), null, Gender.Female, "Доктор", "Украинка", "Херсон", null, null);
//
//        // Устанавливаем супругов
//        father.setSpouse(mother);
//        mother.setSpouse(father);
//
//        // Создаем детей
//        Human[] children = new Human[]{
//                new Human("Анастасия", LocalDate.of(2009, 4, 26), null, Gender.Female, "Ученица", "Русская", "Херсон", father, mother),
//                new Human("Иван", LocalDate.of(2024, 5, 1), null, Gender.Male, null, "Русский", "Сургут", father, mother),
//                new Human("Виктор", LocalDate.of(2024, 5, 1), null, Gender.Male, null, "Русский", "Сургут", father, mother)
//        };
//
//        // Добавляем детей к родителям
//        for (Human child : children) {
//            father.addChild(child);
//            mother.addChild(child);
//        }
//
//        // Создаем дерево семьи
//        FamilyTree familyTree = new FamilyTree();
//
//        // Добавляем членов семьи к дереву
//        Human[] familyMembers = new Human[]{father, mother, children[0], children[1], children[2]};
//        for (Human member : familyMembers) {
//            familyTree.addMember(member);
//        }
        // создать объект FileHandler
        FileHandler fileHandler = new FileHandler();
//
//        // сохранить объект FamilyTree в файл
//        fileHandler.save(familyTree, "family_tree.dat");
//        System.out.println("Данные древа сохранены!");

//        // Работаем с древом
//
//        System.out.println("Информация о членах семьи:\nРодители:");
//        System.out.println(father.getInfo());
//        System.out.println(mother.getInfo());
//        System.out.println("\nДети:");
//        System.out.println(children[0].getInfo());
//        System.out.println(children[1].getInfo());
//        System.out.println(children[2].getInfo());
//
//        System.out.println();
//
//        System.out.println("Дети Ивана:");
//        List<Human> childrenOfIvan = familyTree.getChildren(father);
//        for (Human child : childrenOfIvan) {
//            System.out.println(child.getName());
//        }
//
//        System.out.println();
//
//        System.out.println("Братья и сестры Анастасии:");
//        List<Human> siblingsOfAnastasia = familyTree.getSiblings(children[0]);
//        for (Human sibling : siblingsOfAnastasia) {
//            System.out.println(sibling.getName());
//        }
//
//        System.out.println();
//
//        System.out.println("Супруга Ивана:");
//        Human spouseOfIvan = familyTree.getSpouse(father);
//        System.out.println(spouseOfIvan!= null? spouseOfIvan.getName() : "Отсутствует");
//
//        System.out.println();
//
//        System.out.println("Предки Ивана и Виктора:");
//        List<Human> ancestorsOfIvanAndViktor = familyTree.getAncestors(children[1]);
//        for (Human ancestor : ancestorsOfIvanAndViktor) {
//            System.out.println(ancestor.getName() + " (" + ancestor.getYearsString(ancestor.getAge()) + ")");
//        }
//
//        System.out.println();
//
//        System.out.println("Дети Натальи:");
//        List<Human> childrenOfNatalia = familyTree.getChildren(mother);
//        for (Human child : childrenOfNatalia) {
//            System.out.println(child.getName());
//        }
//
//        System.out.println();
//
//        System.out.println("Братья и сестры Ивана:");
//        List<Human> siblingsOfIvan = familyTree.getSiblings(children[1]);
//        for (Human sibling : siblingsOfIvan) {
//            System.out.println(sibling.getName());
//        }
//
//        System.out.println();
//
//        System.out.println("Предки Анастасии:");
//        List<Human> ancestorsOfAnastasia = familyTree.getAncestors(children[0]);
//        for (Human ancestor : ancestorsOfAnastasia) {
//            System.out.println(ancestor.getName() + " (" + ancestor.getYearsString(ancestor.getAge()) + ")");
//        }

        // загрузить объект FamilyTree из файла
        FamilyTree loadedFamilyTree = fileHandler.load("family_tree.dat");
        System.out.println("Данные древа загружены!");


        // Работаем с древом
        System.out.println("Информация о членах семьи:\nРодители:");
        Human father = loadedFamilyTree.getMemberByName("Иван");
        Human mother = loadedFamilyTree.getMemberByName("Наталья");
        System.out.println(father.getInfo());
        System.out.println(mother.getInfo());
        System.out.println("\nДети:");
        Human[] children = new Human[]{loadedFamilyTree.getMemberByName("Анастасия"), loadedFamilyTree.getMemberByName("Иван"), loadedFamilyTree.getMemberByName("Виктор")};
        System.out.println(children[0].getInfo());
        System.out.println(children[1].getInfo());
        System.out.println(children[2].getInfo());

        System.out.println();

        System.out.println("Дети Ивана:");
        List<Human> childrenOfIvan = loadedFamilyTree.getChildren(father);
        for (Human child : childrenOfIvan) {
            System.out.println(child.getName());
        }

        System.out.println();

        System.out.println("Братья и сестры Анастасии:");
        List<Human> siblingsOfAnastasia = loadedFamilyTree.getSiblings(children[0]);
        for (Human sibling : siblingsOfAnastasia) {
            System.out.println(sibling.getName());
        }

        System.out.println();

        System.out.println("Супруга Ивана:");
        Human spouseOfIvan = loadedFamilyTree.getSpouse(father);
        System.out.println(spouseOfIvan!= null? spouseOfIvan.getName() : "Отсутствует");

        System.out.println();

        System.out.println("Предки Ивана и Виктора:");
        List<Human> ancestorsOfIvanAndViktor = loadedFamilyTree.getAncestors(children[1]);
        for (Human ancestor : ancestorsOfIvanAndViktor) {
            System.out.println(ancestor.getName() + " (" + ancestor.getYearsString(ancestor.getAge()) + ")");
        }

        System.out.println();

        System.out.println("Дети Натальи:");
        List<Human> childrenOfNatalia = loadedFamilyTree.getChildren(mother);
        for (Human child : childrenOfNatalia) {
            System.out.println(child.getName());
        }

        System.out.println();

        System.out.println("Братья и сестры Ивана:");
        List<Human> siblingsOfIvan = loadedFamilyTree.getSiblings(children[1]);
        for (Human sibling : siblingsOfIvan) {
            System.out.println(sibling.getName());
        }

        System.out.println();

        System.out.println("Предки Анастасии:");
        List<Human> ancestorsOfAnastasia = loadedFamilyTree.getAncestors(children[0]);
        for (Human ancestor : ancestorsOfAnastasia) {
            System.out.println(ancestor.getName() + " (" + ancestor.getYearsString(ancestor.getAge()) + ")");
        }
    }
}