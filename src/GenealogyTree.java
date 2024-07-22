import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class GenealogyTree implements Serializable {

    private List<Person> persons;

    public GenealogyTree() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public String toString() {
        StringBuilder treeString = new StringBuilder();
        for (Person person : persons) {
            treeString.append("Имя: ").append(person.getName()).append(", ");
            treeString.append("Год рождения: ").append(person.getBirthDate()).append(", ");
            treeString.append("Пол: ").append(person.getGender()).append("\n");
            treeString.append("Отец: ").append(person.getFather() != null ? person.getFather().getName() : "").append("\n");
            treeString.append("Мать: ").append(person.getMother() != null ? person.getMother().getName() : "").append("\n");
            treeString.append("Дети: ").append(formatChildrenList(person.getChildren())).append("\n\n");
        }
        return treeString.toString();
    }

    private String formatChildrenList(List<Person> children) {
        StringBuilder childrenList = new StringBuilder();
        for (Person child : children) {
            childrenList.append(child.getName()).append(", ");
        }
        if (childrenList.length() > 0) {
            childrenList.delete(childrenList.length() - 2, childrenList.length());
        }
        return childrenList.toString();
    }

    public void sortByName() {
        Collections.sort(persons, Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(persons, Comparator.comparing(Person::getBirthDate));
    }
}
