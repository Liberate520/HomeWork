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
        FamilyTree familyTree = new FamilyTree();
        FileDataHandler fileDataHandler = new FileDataHandler();

        Person ivanovM = new Person("Иванов", "Михаил", "Дмитриевич", Person.Gender.MALE, LocalDate.of(1980, 1, 1));
        Person kuznetzovaLiza = new Person("Кузнецова", "Елизавета", "Сергеевна", Person.Gender.FEMALE, LocalDate.of(1982, 3, 5));
        Person kuznetzovaMary = new Person("Кузнецова", "Мария", "Михайловна", Person.Gender.FEMALE, LocalDate.of(2005, 7, 20));
        Person kuznetzovAl = new Person("Кузнецов", "Александр", "Михайлович", Person.Gender.MALE, LocalDate.of(2007, 11, 15));

        familyTree.addMember(ivanovM);
        familyTree.addMember(kuznetzovaLiza);
        familyTree.addMember(kuznetzovaMary);
        familyTree.addMember(kuznetzovAl);

        familyTree.addParentChildRelationship("Иванов", "Михаил", "Дмитриевич", "Кузнецова", "Мария", "Михайловна");
        familyTree.addParentChildRelationship("Кузнецова", "Елизавета", "Сергеевна", "Кузнецова", "Мария", "Михайловна");
        familyTree.addParentChildRelationship("Иванов", "Михаил", "Дмитриевич", "Кузнецов", "Александр", "Михайлович");
        familyTree.addParentChildRelationship("Кузнецова", "Елизавета", "Сергеевна", "Кузнецов", "Александр", "Михайлович");

        try {
            fileDataHandler.saveToFile("familyTree.dat", familyTree);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }

        try {
            FamilyTree loadedFamilyTree = fileDataHandler.loadFromFile("familyTree.dat");
            System.out.println("Дерево загружено успешно!");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Выберите тип сортировки: ");
            System.out.println("1 - По имени");
            System.out.println("2 - По дате рождения");
            int choice = scanner.nextInt();

            List<Person> sortedPeople;
            if (choice == 1) {
                sortedPeople = loadedFamilyTree.getSortedByName();
            } else if (choice == 2) {
                sortedPeople = loadedFamilyTree.getSortedByDateOfBirth();
            } else {
                System.out.println("Некорректный выбор.");
                return;
            }

            for (Person person : sortedPeople) {
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке: " + e.getMessage());
        }
    }
}