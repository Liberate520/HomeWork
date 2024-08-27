package presenter;

import model.FamilyTree;
import model.human.Gender;
import model.human.Person;
import model.writer.FileLoader;
import model.writer.FileSaver;
import view.ConsoleUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Presenter<T> {
    private FamilyTree<T> familyTree;
    private FileSaver fileSaver;
    private FileLoader fileLoader;

    public Presenter(FamilyTree<T> familyTree, FileLoader fileLoader, FileSaver fileSaver) {
        this.familyTree = familyTree;
        this.fileLoader = fileLoader;
        this.fileSaver = fileSaver;
    }

    public void addPerson(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Введите дату рождения (в формате гггг-мм-дд): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        Person person = new Person(name, age, gender);
        person.setBirthDate(birthDate);
        familyTree.addElement(name, (T) person);

        System.out.println("Человек успешно добавлен в дерево.");
    }

    // Метод для поиска человека по имени
    public void getPerson(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        Person person = (Person) familyTree.getElement(name);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Человек с таким именем не найден.");
        }
    }

    // Метод для получения списка детей родителя
    public void getChildren(Scanner scanner) {
        System.out.print("Введите имя родителя: ");
        String name = scanner.nextLine();
        Person parent = (Person) familyTree.getElement(name);
        if (parent != null) {
            List<Person> children = parent.getChildren();
            if (children.isEmpty()) {
                System.out.println("У этого родителя нет детей.");
            } else {
                for (Person child : children) {
                    System.out.println(child);
                }
            }
        } else {
            System.out.println("Родитель с таким именем не найден.");
        }
    }

    public void addElement(String name, T element) {
        familyTree.addElement(name, element);
    }

    public T getElement(String name) {
        return familyTree.getElement(name);
    }

    public List<T> sortByName() {
        return (List<T>) familyTree.personSortedByName();
    }

    public List<T> sortByAge() {
        return (List<T>) familyTree.personSortedByBirthDay();
    }

    public boolean save(String filePath) {
        return fileSaver.save(familyTree);
    }

    public boolean load(String filePath) {
        FamilyTree<T> loadedTree = (FamilyTree<T>) fileLoader.read();
        if (loadedTree != null) {
            this.familyTree = loadedTree;
            return true;
        }
        return false;
    }
}
