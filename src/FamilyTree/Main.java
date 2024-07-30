package FamilyTree;

import FamilyTree.model.FamilyTree;
import FamilyTree.model.Gender;
import FamilyTree.model.Human;
import FamilyTree.utility.FileHandler;

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
        // создаем объект FileHandler
        FileHandler fileHandler = new FileHandler();

        // сохранить объект FamilyTree в файл
        fileHandler.save(familyTree);
        System.out.println("Данные древа сохранены!");

        // загрузить объект FamilyTree из файла
        FamilyTree loadedFamilyTree = fileHandler.load();
        if (loadedFamilyTree == null) {
            System.out.println("Данные древа НЕ загружены!");
        } else System.out.println("Данные древа загружены!");

// Работаем с древом
        System.out.println("Информация о членах семьи:\nРодители:");
        if (loadedFamilyTree != null) {
            father = loadedFamilyTree.getMemberByName("Иван");
            mother = loadedFamilyTree.getMemberByName("Наталья");

            System.out.println(father.getInfo());
            System.out.println(mother.getInfo());
            System.out.println("\nДети:");
            List<Human> childrenOfFather = loadedFamilyTree.getChildren(father);
            for (Human child : childrenOfFather) {
                System.out.println(child.getInfo());
            }

            System.out.println();

            System.out.println("Дети Ивана:");
            List<Human> childrenOfIvan = loadedFamilyTree.getChildren(father);
            for (Human child : childrenOfIvan) {
                System.out.println(child.getName());
            }

            System.out.println();

            System.out.println("Братья и сестры Анастасии:");
            Human anastasia = loadedFamilyTree.getMemberByName("Анастасия");
            List<Human> siblings = loadedFamilyTree.getSiblings(anastasia);
            for (Human sibling : siblings) {
                System.out.println(sibling.getName());
            }

            System.out.println();

            System.out.println("Супруга Ивана:");
            Human spouse = loadedFamilyTree.getSpouse(father);
            System.out.println(spouse != null ? spouse.getName() : "Отсутствует");

            System.out.println();

            System.out.println("Предки Ивана и Виктора:");
            Human viktor = loadedFamilyTree.getMemberByName("Виктор");
            List<Human> ancestors = loadedFamilyTree.getAncestors(viktor);
            for (Human ancestor : ancestors) {
                System.out.println(ancestor.getName() + " (" + ancestor.getYearsString(ancestor.getAge()) + ")");
            }

            System.out.println();

            System.out.println("Дети Натальи:");
            List<Human> childrenOfMother = loadedFamilyTree.getChildren(mother);
            for (Human child : childrenOfMother) {
                System.out.println(child.getName());
            }

            System.out.println();

            System.out.println("Братья и сестры Виктора:");
            List<Human> siblingsOfViktor = loadedFamilyTree.getSiblings(viktor);
            for (Human sibling : siblingsOfViktor) {
                System.out.println(sibling.getName());
            }

            System.out.println();

            System.out.println("Предки Анастасии:");
            ancestors = loadedFamilyTree.getAncestors(anastasia);
            for (Human ancestor : ancestors) {
                System.out.println(ancestor.getName() + " (" + ancestor.getYearsString(ancestor.getAge()) + ")");
            }

            System.out.println();

            System.out.println("Сортировка по имени:");
            loadedFamilyTree.sortByname();
            for (Human human : loadedFamilyTree) {
                System.out.println(human.getInfo());
            }

            System.out.println("\nСортировка по дате рождения:");
            loadedFamilyTree.sortByBirthDate();
            for (Human human : loadedFamilyTree) {
                System.out.println(human.getInfo());
            }

            System.out.println("\nСортировка по возрасту:");
            loadedFamilyTree.sortByAge();
            for (Human human : loadedFamilyTree) {
                System.out.println(human.getInfo());
            }
        } else System.out.println("Данные древа НЕ загружены!");
    }
}