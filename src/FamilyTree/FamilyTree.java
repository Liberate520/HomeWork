package FamilyTree;
import java.util.*;
import Human.Human;
import java.io.Serializable;


public class FamilyTree implements Serializable, Iterable<Human>  {
    private static final long serialVersionUID = 1L;

    private Map<Integer, Human> humans;

    // Конструктор класса FamilyTree
    public FamilyTree() {
        this.humans = new HashMap<>();
    }

    // Метод для добавления человека в дерево
    public void addHuman(Human human) {
        humans.put(human.getId(), human);
    }

    // Метод для получения человека по ID
    public Human getHuman(int id) {
        return humans.get(id);
    }

    // Метод для получения детей человека по ID
    public List<Human> getChildren(int id) {
        Human human = humans.get(id);
        return (human != null) ? human.getChildren() : new ArrayList<>();
    }

    public void printTree() {
        for (Human human : humans.values()) {
            System.out.println(human);
        }
    }

    @Override
    public Iterator<Human> iterator() {
        return humans.values().iterator();
    }

    public void sortByName() {
        List<Human> humanList = new ArrayList<>(humans.values());
        humanList.sort(Comparator.comparing(Human::getName));
        humans.clear();
        for (Human human : humanList) {
            humans.put(human.getId(), human);
        }
    }

    public void sortByBirthDate() {
        List<Human> humanList = new ArrayList<>(humans.values());
        humanList.sort(Comparator.comparing(Human::getBirthDate));
        humans.clear();
        for (Human human : humanList) {
            humans.put(human.getId(), human);
        }
    }
}


