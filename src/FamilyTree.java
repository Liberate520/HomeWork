import java.util.ArrayList;
import java.util.List;

// Класс FamilyTree представляет генеалогическое древо
class FamilyTree {
    private List<Person> members;
    private FileOperations fileOperations; // Добавлено поле для операций с файлами

    public FamilyTree() {
        this.members = new ArrayList<>();
        this.fileOperations = new FileFamilyTreeOperations(); // Инициализация объекта для операций с файлами
    }

    // Добавление человека в генеалогическое древо
    public void addPerson(Person person) {
        this.members.add(person);
    }

    // Получение всех детей выбранного человека
    public List<Person> getChildrenOf(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person.getChildren();
            }
        }
        return new ArrayList<>();
    }

    // Получение всех людей в генеалогическом древе
    public List<Person> getAllMembers() {
        return members;
    }

    // Поиск человека по имени
    public Person findPersonByName(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    // Демонстрация всех членов дерева и их детей
    public void displayTree() {
        for (Person person : members) {
            System.out.println(person);
            List<Person> children = person.getChildren();
            if (!children.isEmpty()) {
                System.out.println("  Дети: " + children);
            }
        }
    }

    // Сохранение генеалогического древа в файл
    public void saveToFile(String filename) {
        fileOperations.saveToFile(filename, members);
    }

    // Загрузка генеалогического древа из файла
    public void loadFromFile(String filename) {
        this.members = fileOperations.loadFromFile(filename);
    }
}