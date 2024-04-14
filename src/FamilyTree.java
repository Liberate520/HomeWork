import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

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
}

