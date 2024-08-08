package FamilyTree;

import FamilyTree.model.FamilyTree;
import FamilyTree.model.Gender;
import FamilyTree.model.Human;
import FamilyTree.utility.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        // Создаем старших членов семьи
//        Human grandFather = new Human("Иван", LocalDate.of(1952, 6, 1), null, Gender.Male, "Инженер", "Русский", "Херсон", null, null);
//        Human grandMother = new Human("Надежда", LocalDate.of(1952, 2, 17), null, Gender.Female, "Учитель", "Украинка", "Херсон", null, null);
//
//        Human grandFather1 = new Human("Виктор", LocalDate.of(1961, 7, 19), null, Gender.Male, "Инженер", "Русский", "Херсон", null, null);
//        Human grandMother1 = new Human("Людмила", LocalDate.of(1960, 4, 26), null, Gender.Female, "Учитель", "Украинка", "Херсон", null, null);
//
//        // Создаем родителей
//        Human father = new Human("Иван", LocalDate.of(1981, 5, 1), null, Gender.Male, "Инженер", "Русский", "Херсон", grandFather, grandMother);
//        Human mother = new Human("Наталья", LocalDate.of(1983, 6, 12), null, Gender.Female, "Доктор", "Украинка", "Херсон", grandFather1, grandMother1);
//
//        // Устанавливаем супругов
//        grandFather.setSpouse(grandMother);
//        grandMother.setSpouse(grandFather);
//
//        grandFather1.setSpouse(grandMother1);
//        grandMother1.setSpouse(grandFather1);
//
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
//        // Добавляем детей и внуков к предкам
//        grandFather.addChild(father);
//        grandMother.addChild(father);
//        grandFather1.addChild(mother);
//        grandMother1.addChild(mother);
//
//        for (Human child : children) {
//            grandFather.addGrandchild(child);
//            grandMother.addGrandchild(child);
//            grandFather1.addGrandchild(child);
//            grandMother1.addGrandchild(child);
//            father.addChild(child);
//            mother.addChild(child);
//        }
//
//        // Создаем дерево семьи
//        FamilyTree<Human> familyTree = new FamilyTree<>();
//
//        // Добавляем членов семьи к дереву
//
//        familyTree.addMember(grandFather);
//        familyTree.addMember(grandMother);
//        familyTree.addMember(grandFather1);
//        familyTree.addMember(grandMother1);
//        familyTree.addMember(father);
//        familyTree.addMember(mother);
//
//        for (Human child : children) {
//            familyTree.addMember(child);
//        }

        // создаем объект FileHandler
        FileHandler fileHandler = new FileHandler();

//        // сохраняем объект FamilyTree в файл
//        fileHandler.save(familyTree);
//        System.out.println("Данные древа сохранены!");

        // загружаем объект FamilyTree из файла
        try {
            FamilyTree loadedFamilyTree = fileHandler.load();

            if (loadedFamilyTree != null) {
                System.out.println("Данные древа загружены!\n");

                // Вывод информации о семье
                loadedFamilyTree.printFamilyTree();

                System.out.println();

                List<Human> root = loadedFamilyTree.getMembers();

                Human loadFather = null;
                for (Human member : root) {
                    if (member.getName().equals("Иван") && member.getBirthDate().equals(LocalDate.of(1981, 5, 1))) {
                        loadFather = member;
                        break;
                    }
                }

                List<Human> loadChildren = new ArrayList<>();
                for (Human member : root) {
                    if (member.getFather() != null && member.getFather().equals(loadFather)) {
                        loadChildren.add(member);
                    }
                }

                Human loadGrandFather = null;
                for (Human member : root) {
                    if (member.getName().equals("Иван") && member.getBirthDate().equals(LocalDate.of(1952, 6, 1))) {
                        loadGrandFather = member;
                        break;
                    }
                }

                Human loadMother = null;
                for (Human member : root) {
                    if (member.getName().equals("Наталья") && member.getBirthDate().equals(LocalDate.of(1983, 6, 12))) {
                        loadMother = member;
                        break;
                    }
                }

                // Примеры использования методов
                loadedFamilyTree.printChildren(loadFather);
                System.out.println();
                loadedFamilyTree.printSiblings(loadChildren.get(0));
                System.out.println();
                loadedFamilyTree.printAncestors(loadMother);
                System.out.println();
                loadedFamilyTree.printGrandchildren(loadGrandFather);
                System.out.println();
                loadedFamilyTree.printSpouse(loadMother);
                System.out.println();
                loadedFamilyTree.printAgeStatistics();

                System.out.println();

                // Вывод информации о возрасте членов семьи
                System.out.println("Возраст членов семьи:");
                for (Object memberObject : loadedFamilyTree.getMembers()) {
                    Human member = (Human) memberObject;
                    System.out.println(member.getName() + ": " + member.getAge());
                }

                System.out.println();

                // Вывод информации о общем возрасте всех членов семьи
                System.out.println("Общий возраст членов семьи:");
                System.out.println(loadedFamilyTree.getAge());

                System.out.println();

                // Сортировка членов семьи по имени
                loadedFamilyTree.sortByName();
                System.out.println("Члены семьи, отсортированные по имени:");
                loadedFamilyTree.printFamilyTree();

                System.out.println();

                // Сортировка членов семьи по дате рождения
                loadedFamilyTree.sortByBirthDate();
                System.out.println("Члены семьи, отсортированные по дате рождения:");
                loadedFamilyTree.printFamilyTree();

                System.out.println();

                // Сортировка членов семьи по возрасту
                loadedFamilyTree.sortByAge();
                System.out.println("Члены семьи, отсортированные по возрасту:");
                loadedFamilyTree.printFamilyTree();
            }
        } catch (Exception e) {
            System.out.println("Данные древа НЕ загружены!");
        }
    }
}