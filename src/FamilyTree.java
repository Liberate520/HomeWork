import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FamilyTree<E extends FamilyTreeElement> implements Serializable {
    private LinkedList<E> list;

    public FamilyTree() {
        list = new LinkedList<>();
    }

    public void addHuman(E human) {
        list.add(human);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---\n");
        for (E human : list) {
            stringBuilder.append(human.toString());
            stringBuilder.append("\n---\n");
        }
        return stringBuilder.toString();
    }

    // Метод для сортировки членов семьи по возрасту и возврата нового списка
    public List<E> sortByAge() {
        List<E> sortedByAge = new LinkedList<>(list);
        Collections.sort(sortedByAge, Comparator.comparingInt(E::getAge));
        return sortedByAge;
    }

    // Метод для сортировки членов семьи по дате рождения и возврата нового списка
    public List<E> sortByDateOfBirth() {
        List<E> sortedByDOB = new LinkedList<>(list);
        Collections.sort(sortedByDOB, Comparator.comparing(E::getDateOfBirth));
        return sortedByDOB;
    }
}