import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра генеалогического древа
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        Person john = new Person("John", 50);
        Person jane = new Person("Jane", 48);
        Person mike = new Person("Mike", 20);
        Person anna = new Person("Anna", 18);

        // Добавление детей
        john.addChild(mike);
        john.addChild(anna);

        // Добавление людей в генеалогическое древо
        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(mike);
        familyTree.addMember(anna);

        // Запись данных в файл
        DataStorage storage = new FileDataStorage();
        try {
            storage.saveToFile("family_tree.dat", familyTree.getMembers());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение данных из файла
        List<Person> loadedMembers;
        try {
            loadedMembers = storage.loadFromFile("family_tree.dat");
            System.out.println("Loaded members from file:");
            for (Person person : loadedMembers) {
                System.out.println(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Проведение исследования: получение всех детей Джона
        Person parent = familyTree.findPersonByName("John");
        if (parent != null) {
            System.out.println("Children of " + parent.getName() + ":");
            for (Person child : familyTree.getChildrenOf(parent)) {
                System.out.println(child);
            }
        } else {
            System.out.println("Person not found");
        }
    }
}