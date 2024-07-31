package family_tree.family_tree;
import family_tree.human.Human;
import family_tree.human.HumanComparatorByDOB;
import family_tree.human.HumanComparatorByName;
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

    public void addHuman(T human) {
        human.setId(++humanId);
        humans.add(human);
    }


    public void sortByName(){
        humans.sort(new HumanComparatorByName<>());
    }
    public void sortByDOB(){
        humans.sort(new HumanComparatorByDOB<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humans);
    }

}