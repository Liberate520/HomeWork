package familytree.main;

import familytree.io.FileDataHandler;
import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Параметризация FamilyTree типом Person
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileDataHandler fileDataHandler = new FileDataHandler();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Выберите команду: ");
            System.out.println("1 - Добавить нового члена");
            System.out.println("2 - Найти члена по имени");
            System.out.println("3 - Добавить родительско-детскую связь");
            System.out.println("4 - Вывести всех членов, отсортированных по имени");
            System.out.println("5 - Вывести всех членов, отсортированных по дате рождения");
            System.out.println("6 - Сохранить дерево в файл");
            System.out.println("7 - Загрузить дерево из файла");
            System.out.println("0 - Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    // Логика для добавления нового члена
                    break;
                case 2:
                    // Логика для поиска члена по имени
                    break;
                case 3:
                    // Логика для добавления родительско-детской связи
                    break;
                case 4:
                    List<Person> sortedByName = familyTree.getSortedByName();
                    for (Person person : sortedByName) {
                        System.out.println(person);
                    }
                    break;
                case 5:
                    List<Person> sortedByDate = familyTree.getSortedByDateOfBirth();
                    for (Person person : sortedByDate) {
                        System.out.println(person);
                    }
                    break;
                case 6:
                    try {
                        fileDataHandler.saveToFile("familyTree.dat", familyTree);
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении: " + e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        FamilyTree<Person> loadedFamilyTree = fileDataHandler.loadFromFile("familyTree.dat");
                        familyTree = loadedFamilyTree;
                        System.out.println("Дерево загружено успешно!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Ошибка при загрузке: " + e.getMessage());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Некорректный выбор.");
                    break;
            }
        }
    }
}

//        Person ivanovM = new Person("Иванов", "Михаил", "Дмитриевич", Person.Gender.MALE, LocalDate.of(1980, 1, 1));
//        Person kuznetzovaLiza = new Person("Кузнецова", "Елизавета", "Сергеевна", Person.Gender.FEMALE, LocalDate.of(1982, 3, 5));
//        Person kuznetzovaMary = new Person("Кузнецова", "Мария", "Михайловна", Person.Gender.FEMALE, LocalDate.of(2005, 7, 20));
//        Person kuznetzovAl = new Person("Кузнецов", "Александр", "Михайлович", Person.Gender.MALE, LocalDate.of(2007, 11, 15));
//
//        familyTree.addMember(ivanovM);
//        familyTree.addMember(kuznetzovaLiza);
//        familyTree.addMember(kuznetzovaMary);
//        familyTree.addMember(kuznetzovAl);
//
//        familyTree.addParentChildRelationship("Иванов", "Михаил", "Дмитриевич", "Кузнецова", "Мария", "Михайловна");
//        familyTree.addParentChildRelationship("Кузнецова", "Елизавета", "Сергеевна", "Кузнецова", "Мария", "Михайловна");
//        familyTree.addParentChildRelationship("Иванов", "Михаил", "Дмитриевич", "Кузнецов", "Александр", "Михайлович");
//        familyTree.addParentChildRelationship("Кузнецова", "Елизавета", "Сергеевна", "Кузнецов", "Александр", "Михайлович");

//        try {
//            fileDataHandler.saveToFile("familyTree.dat", familyTree);
//        } catch (IOException e) {
//            System.out.println("Ошибка при сохранении: " + e.getMessage());
//        }

//        try {
//            FamilyTree<Person> loadedFamilyTree = fileDataHandler.loadFromFile("familyTree.dat");
//            System.out.println("Дерево загружено успешно!");
//
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("Выберите тип сортировки: ");
//            System.out.println("1 - По имени");
//            System.out.println("2 - По дате рождения");
//            int choice = scanner.nextInt();

//            List<Person> sortedPeople;
//            if (choice == 1) {
//                sortedPeople = loadedFamilyTree.getSortedByName();
//            } else if (choice == 2) {
//                sortedPeople = loadedFamilyTree.getSortedByDateOfBirth();
//            } else {
//                System.out.println("Некорректный выбор.");
//                return;
//            }
//
//            for (Person person : sortedPeople) {
//                System.out.println(person);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Ошибка при загрузке: " + e.getMessage());
//        }
//    }
//}