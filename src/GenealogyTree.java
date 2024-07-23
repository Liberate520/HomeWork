import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class GenealogyTree<T extends Person> implements Serializable, Iterable<T> {

    private List<T> persons;

    public GenealogyTree() {
        persons = new ArrayList<>();
    }

    public void addPerson(T person) {
        persons.add(person);
    }

    public void sortByName() {
        persons.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        persons.sort(Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public Iterator<T> iterator() {
        return persons.iterator();
    }

    @Override
    public String toString() {
        StringBuilder treeString = new StringBuilder();
        for (T person : persons) {
            treeString.append("Имя: ").append(person.getName()).append(", ");
            treeString.append("Год рождения: ").append(person.getBirthDate()).append(", ");
            treeString.append("Пол: ").append(person.getGender()).append("\n");
            treeString.append("Отец: ").append(person.getFather() != null ? person.getFather().getName() : "").append("\n");
            treeString.append("Мать: ").append(person.getMother() != null ? person.getMother().getName() : "").append("\n");
            treeString.append("Дети: ").append(formatChildrenList((List<T>) person.getChildren())).append("\n\n");
        }
        return treeString.toString();
    }

    private String formatChildrenList(List<T> children) {
        StringBuilder childrenList = new StringBuilder();
        for (T child : children) {
            childrenList.append(child.getName()).append(", ");
        }
        if (childrenList.length() > 0) {
            childrenList.delete(childrenList.length() - 2, childrenList.length());
        }
        return childrenList.toString();
    }
}
