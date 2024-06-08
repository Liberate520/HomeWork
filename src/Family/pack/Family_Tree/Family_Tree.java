package Family.pack.Family_Tree;

import Family.pack.Human.Human;
import Family.pack.Human.HumanObserver;
import Family.pack.Human.comparators.HumanComparatorByAge;
import Family.pack.Human.comparators.HumanComparatorByCountOfChildren;
import Family.pack.Human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family_Tree<T extends FamilyTreeItem<T>> implements HumanObserver, Serializable, Iterable<T> {

    private static final long serialVersionUID = 1L;
    protected List<T> familyTree;

    public Family_Tree() {
        familyTree = new ArrayList<>();
        Human.addObserver(this);
    }

    protected void addCreatureToFamilyTree(T human) {
        familyTree.add(human);
    }

    protected List<T> getFamilyTree() {
        return familyTree;
    }

    public void printFamilyTree() {
        for (T human : familyTree) {
            System.out.println(human.getInfo());
        }
    }


    public void onHumanCreated(Object human) {
        addCreatureToFamilyTree((T) human);
    }



    public void sortByName(){
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge<>());
    }

    public void sortByCountOfChildren(){
        familyTree.sort(new HumanComparatorByCountOfChildren<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(familyTree);
    }
}
