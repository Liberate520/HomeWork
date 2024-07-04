import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Класс FamilyTree представляет генеалогическое древо и реализует Serializable
class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Person> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
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
}
