package family_tree.model.family_tree;
import family_tree.model.human.Human;
import family_tree.model.human.HumanComparatorByDOB;
import family_tree.model.human.HumanComparatorByName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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

    public Human searchByHumanID(String HumanID){
        return (Human) humans.get(Integer.parseInt(HumanID)-1);
    }

    public Human searchByHumanName(String humanName){
        for (T human : humans){
            if(Objects.equals(human.getName(), humanName)){
                return (Human) human;
            }
        }
        return null;
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

    @Override
    public String toString() {
        return "FamilyTree{" +
                "id=" + id +
                ", humanId=" + humanId +
                ", humans=" + humans +
                '}';
    }
}