package family_tree.family_tree;

import family_tree.ComparatorByAge;
import family_tree.ComparatorByName;
import family_tree.FamilyTreeItem;
import family_tree.FamilyTreeIterator;
import family_tree.human.Human;

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

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humans.contains(human)){
            humans.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
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
        Collections.sort(humans, new ComparatorByAge());
    }

    public void sortByName(){
        Collections.sort(humans, new ComparatorByName());
    }

    public Iterator<E> iterator(){
        return new FamilyTreeIterator(humans);
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

