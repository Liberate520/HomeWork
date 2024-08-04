import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable, Iterable<Human> {
    private static final long serialVersionUID = 1L;
    private Map<String, Human> humans;

    public FamilyTree() {
        this.humans = new HashMap<>();
    }

    public void addHuman(Human human) {
        humans.put(human.getId(), human);
    }

    public Human getHumanById(String id) {
        return humans.get(id);
    }

    public List<Human> getHumanByName(String name) {
        return humans.values().stream()
                .filter(human -> human.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Human> getHumanBySurname(String surname) {
        return humans.values().stream()
                .filter(human -> human.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList());
    }

    public List<Human> getAllChildren(String id) {
        Human human = getHumanById(id);
        return human != null ? human.getChildren() : new ArrayList<>();
    }

    public List<Human> getAllHumans() {
        return new ArrayList<>(humans.values());
    }

    @Override
    public Iterator<Human> iterator() {
        return humans.values().iterator();
    }

    public List<Human> sortByAge() {
        return humans.values().stream()
                .sorted(Comparator.comparingInt(Human::getAge))
                .collect(Collectors.toList());
    }

    public List<Human> sortByGender() {
        return humans.values().stream()
                .sorted(Comparator.comparing(Human::getGender))
                .collect(Collectors.toList());
    }
}