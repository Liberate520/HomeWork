import familytree.FamilyTree;
import person.Gender;
import person.Person;
import writer.FileHandler;
import writer.Writer;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляры класса Person
        Person john = new Person("John", LocalDate.of(1974, 1, 1), null, Gender.MALE);
        Person jane = new Person("Jane", LocalDate.of(1976, 5, 15), null, Gender.FEMALE);
        Person anna = new Person("Anna", LocalDate.of(1999, 3, 21), null, Gender.FEMALE);
        Person bob = new Person("Bob", LocalDate.of(2004, 7, 30), null, Gender.MALE);

        // Создаем семейное дерево
        FamilyTree tree = new FamilyTree();

        // Добавляем людей в семейное дерево
        tree.addPerson(john);
        tree.addPerson(jane);
        tree.addPerson(anna);
        tree.addPerson(bob);

        // Связываем родителей и детей
        john.addChild(anna);
        john.addChild(bob);
        jane.addChild(anna);
        jane.addChild(bob);

        // Проводим исследование
        List<Person> childrenOfJohn = tree.getChildren("John");
        List<Person> parentsOfAnna = tree.getParents("Anna");

        System.out.println("Children of John: " + childrenOfJohn);
        System.out.println("Parents of Anna: " + parentsOfAnna);

        System.out.println("Unsorted FamilyTree:");
        System.out.println(tree);

        // Сортируем по имени
        tree.sortByName();
        System.out.println("FamilyTree sorted by name:");
        System.out.println(tree);

        // Сортируем по дате рождения
        tree.sortByBirthDate();
        System.out.println("FamilyTree sorted by birth date:");
        System.out.println(tree);

        // Записываем семейное дерево в файл
        Writer fileHandler = new FileHandler();
        String fileName = "familytree.ser";
        fileHandler.writeToFile(tree, fileName);

        // Читаем семейное дерево из файла
        FamilyTree loadedTree = fileHandler.readFromFile(fileName);
        System.out.println("Loaded FamilyTree from file:");
        System.out.println(loadedTree);
    }
}
