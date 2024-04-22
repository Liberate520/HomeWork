import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//Создаём класс фамильное дерево
public class FamilyTree implements Serializable {
    private LinkedList<Human> humanList;

    public FamilyTree() {
        humanList = new LinkedList<>();
    }
    public void addHuman(Human human) {
        humanList.add(human);
    }
    //
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---\n");
        for (Human human: humanList){
            stringBuilder.append(human.toString());
            stringBuilder.append("\n---\n");
        }
        return stringBuilder.toString();
    }
    // Метод для сортировки членов семьи по возрасту и возврата нового списка
    public List<Human> sortByAge() {
        List<Human> sortedByAge = new LinkedList<>(humanList);
        Collections.sort(sortedByAge, Comparator.comparingInt(Human::getAge));
        return sortedByAge;
    }

    // Метод для сортировки членов семьи по дате рождения и возврата нового списка
    public List<Human> sortByDateOfBirth() {
        List<Human> sortedByDOB = new LinkedList<>(humanList);
        Collections.sort(sortedByDOB, Comparator.comparing(Human::getDateOfBirth));
        return sortedByDOB;
    }
}

