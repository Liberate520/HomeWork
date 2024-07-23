import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GenealogyTree implements Serializable, Iterable<Person> {

    private List<Person> persons;

    public GenealogyTree() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void sortByName() {
        persons.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void sortByBirthDate() {
        persons.sort((p1, p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()));
    }

    @Override
    public Iterator<Person> iterator() {
        return persons.iterator();
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

}
