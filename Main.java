import model.*;
import io.FileHandler;
import io.FileHandlerImpl;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();

        Person father = new Person("Алексей", "01.01.1970", Gender.MALE);
        Person mother = new Person("Елена", "05.05.1975", Gender.FEMALE);
        Person child1 = new Person("Иван", "20.12.2000", Gender.MALE);
        Person child2 = new Person("Мария", "15.08.2005", Gender.FEMALE);

        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);

        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        // Вывод всех членов семьи без сортировки
        System.out.println("Все члены семьи (без сортировки):");
        for (Person person : familyTree) {
            System.out.println(person);
        }

        // Сортировка по имени перед выводом
        familyTree.sortByName(Person::getName);
        System.out.println("\nВсе члены семьи (отсортировано по имени):");
        for (Person person : familyTree) {
            System.out.println(person);
        }

        // Сортировка по дате рождения перед выводом
        familyTree.sortByBirthDate(Person::getBirthDate);
        System.out.println("\nВсе члены семьи (отсортировано по дате рождения):");
        for (Person person : familyTree) {
            System.out.println(person);
        }

        // Сохранение дерева в файл
        FileHandler fileHandler = new FileHandlerImpl();
        fileHandler.writeToFile("familyTree.ser", familyTree);

        // Загрузка дерева из файла
        FamilyTree<Person> loadedTree = fileHandler.readFromFile("familyTree.ser");

                }
    }

