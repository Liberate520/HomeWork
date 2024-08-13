package family_tree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<T extends ItemFamilyTree> implements Serializable, Iterable<T> {
    private int id;
    private int humanId;
    private List<T> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public List<T> getHumans() {
        return humans;
    }

    public void addHuman(T human) {
        human.setId(++humanId);
        humans.add(human);
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humans);
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "id=" + id +
                ", humanId=" + humanId +
                ", humans=" + humans +
                '}';
    }
}