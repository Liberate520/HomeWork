package Model.FamilyTree;

import Model.FamilyTree.iterators.FamilyTreeIterator;
import Model.Human.comparators.HumanComparatorByAge;
import Model.Human.comparators.HumanComparatorByCountOfChildren;
import Model.Human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T> {

    protected List<T> familyTree;

    public FamilyTree(){
        familyTree = new ArrayList<>();
    }

    public void addCreatureToFamilyTree(T creature){
        familyTree.add(creature);

    }

    public List<T> getFamilyTree(){
        return familyTree;
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
