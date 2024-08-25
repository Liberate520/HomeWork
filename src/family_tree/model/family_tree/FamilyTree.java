package family_tree.model.family_tree;

import family_tree.model.human.comparators.ComparatorByAge;
import family_tree.model.human.comparators.ComparatorByName;
import family_tree.model.FamilyTreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private long humanId;
    private List<E> humans;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humans){
        this.humans = humans;
    }

    public void add(E human){
        this.humans.add(human);
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human : humans) {
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public E getById(long id){
        for (E human: humans){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public void sortByAge(){
        Collections.sort(humans, new ComparatorByAge<>());
    }

    public void sortByName(){
        Collections.sort(humans, new ComparatorByName<>());
    }

    public Iterator<E> iterator(){
        return new FamilyTreeIterator<>(humans);
    }

    @Override
    public String toString(){
        return getInfo();
    }
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В семье ");
        stringBuilder.append(humans.size());
        stringBuilder.append(" человек(а) \n");
        for (E human : humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

