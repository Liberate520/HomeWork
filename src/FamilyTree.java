import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    /** Люди в FamilyTree */
    private List<Person> people;

    /**
     * Создание FamilyTree
     */
    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    /** Добавить человека */
    public void addPerson(Person person) {
        this.people.add(person);
    }

    /** Вывод всех детей человека */
    public List<Person> getAllChildren(Person person) {
        return person.getChildren();
    }

    /** Поиск человека по имени в FamilyTree */
    public String findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                return "Найдет " + name + "\n" + person;
            }
        }
        return "Человек " + name + " не найден";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("FamilyTree:\n");
        for (Person person : people) {
            result.append(person.toString()).append("\n");
        }
        return result.toString();
    }
}
