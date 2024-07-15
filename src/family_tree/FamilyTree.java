package family_tree;

import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<E extends ItemFamilyTree> implements Serializable, Iterable<E>{
    private List<E> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public E getReadName(String nameHuman){
        for (E human: humans){
            if (human.getName().equals(nameHuman)){
                return human;
            }
        }
        return null;
    }

    public void addHuman(E human){
        humans.add(human);
    }

    public E getHuman(int id){
        for (E human: humans){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public void sortByName(){
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humans.sort(new HumanComparatorByAge<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humans);
    }

}
