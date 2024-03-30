package tree;

import writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    static FamilyTree familyTree = new FamilyTree();

    public static FamilyTree<Person> prep(){

        // Добавляем людей в дерево
        Person person1 = new Person("John", Gender.Male, LocalDate.of(1950, 05, 30));
        Person person2 = new Person("Jane", Gender.Female, LocalDate.of(1952, 02, 15));
        Person person3 = new Person("Tom", Gender.Male, LocalDate.of(1960, 04, 2));
        Person person4 = new Person("Emily", Gender.Female, LocalDate.of(1990, 8, 5));
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);


        // Добавляем отношения в дерево
        familyTree.addRelationship("John", "Tom");
        familyTree.addRelationship("Jane", "Tom");
        familyTree.addRelationship("John", "Emily");
        familyTree.addRelationship("Jane", "Emily");

        return familyTree;
    }
    public static void main(String[] args) {
        prep();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить пользователя в дерево");
            System.out.println("2. Добавить отношения пользователя с кем-то");
            System.out.println("3. Отобразить дерево");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // считываем перевод строки после ввода числа

            switch (choice) {
                case 1:
                    System.out.println("Введите имя пользователя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите пол пользователя (Male/Female):");
                    Gender gender = Gender.valueOf(scanner.nextLine());
                    System.out.println("Введите год рождения пользователя (гггг-мм-дд):");
                    LocalDate birthDate = LocalDate.parse(scanner.nextLine());

                    Person person = new Person(name, gender, birthDate);
                    familyTree.addPerson(person);
                    System.out.println("Пользователь успешно добавлен в дерево.");
                    break;
                case 2:
                    System.out.println("Введите имя родителя:");
                    String parentName = scanner.nextLine();
                    System.out.println("Введите имя ребенка:");
                    String childName = scanner.nextLine();

                    familyTree.addRelationship(parentName, childName);
                    System.out.println("Отношения успешно добавлены.");
                    break;
                case 3:
                    System.out.println("Дерево:");
                    displayFamilyTree(familyTree);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите существующее действие.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }

    private static void displayFamilyTree(FamilyTree<FamilyTreeEntity> tree) {
        for (FamilyTreeEntity person : tree) {
            displayPerson(person, 0);
        }
    }

    private static void displayPerson(FamilyTreeEntity person, int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("  "); // отступ для каждого уровня
        }
        System.out.println(indentation + person.getName());
        for (FamilyTreeEntity child : person.getChildren()) {
            displayPerson(child, level + 1); // рекурсивно отображаем каждого ребенка
        }
    }



    public void prevVer() {
        FamilyTree familyTree = new FamilyTree();

        // Добавляем людей в дерево
        Person person1 = new Person("John", Gender.Male, LocalDate.of(1950, 05, 30));
        Person person2 = new Person("Jane", Gender.Female, LocalDate.of(1952, 02, 15));
        Person person3 = new Person("Tom", Gender.Male, LocalDate.of(1960, 04, 2));
        Person person4 = new Person("Emily", Gender.Female, LocalDate.of(1990, 8, 5));
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);

        // Добавляем отношения в дерево
        familyTree.addRelationship("John", "Tom");
        familyTree.addRelationship("Jane", "Tom");
        familyTree.addRelationship("John", "Emily");
        familyTree.addRelationship("Jane", "Emily");

//        // Получаем всех детей выбранного человека
//        List<Person> children = familyTree.getChildrenOfPerson("John");
//        System.out.println("Children of John:");
//        for (Person child : children) {
//            System.out.println(child);
//        }
//        System.out.println(familyTree);

        familyTree.sortByName();
        familyTree.sortByDateOfBirth();

        for (Object person : familyTree) {
            System.out.println(person.toString());
        }

        FileHandler handler = new FileHandler();
        handler.save(familyTree);
    }
}
