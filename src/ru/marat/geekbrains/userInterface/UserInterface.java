package ru.marat.geekbrains.userInterface;

import ru.marat.geekbrains.models.FamilyTree;
import ru.marat.geekbrains.models.Person;
import ru.marat.geekbrains.models.PersonRelationship;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private FamilyTree<Person> familyTree;

    public UserInterface(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду (add, list, sort_name, sort_date, exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    // Логика добавления нового члена семьи
                    break;
                case "list":
                    System.out.println(familyTree);
                    break;
                case "sort_name":
                    familyTree.sortByName(Comparator.comparing(Person::getName));
                    System.out.println("Отсортировано по имени.");
                    break;
                case "sort_date":
                    familyTree.sortByBirthDate(Comparator.comparing(Person::getBirthDate));
                    System.out.println("Отсортировано по дате рождения.");
                    break;
                case "exit":
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Person john = new Person("John", LocalDate.of(1983, 5, 10), "Male");
        Person jane = new Person("Jane", LocalDate.of(1985, 3, 15), "Female");
        Person child1 = new Person("Child1", LocalDate.of(2005, 6, 20), "Female");
        Person child2 = new Person("Child2", LocalDate.of(2008, 9, 5), "Male");

        child1.setMother(jane);
        child1.setFather(john);
        child2.setMother(jane);
        child2.setFather(john);

        FamilyTree<Person> familyTree = new FamilyTree<>();
        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        UserInterface ui = new UserInterface(familyTree);
        ui.start();
    }
}
