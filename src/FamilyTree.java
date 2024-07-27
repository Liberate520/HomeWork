import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    @Serial
    private static final long serialVersionUID = 0;
    private List<Human> human;
    private long humansID;
    private Human[] humanlist;

    public FamilyTree() {
        this.human = new ArrayList<>();
    }


    public List<Human> getHuman() {
        return human;
    }

    public void addToParents(@NotNull Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(@NotNull Human human) {
        for (Human child : human.getChildren()) {
            child.addParents(human);
        }
    }

    public Human findHuman(String name) {
        for (Human person : human) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }


    private boolean checkID(long ID) {
        return ID < humansID && ID >= 0;
    }

    public Human getByID(long ID) {
        for (Human human : humanlist) {
            if (human.getID() == ID) {
                return human;
            }
        }
        return  null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human : human) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @NotNull
    @Override
    public Iterator<Human> iterator() {
        return null;
    }
}
