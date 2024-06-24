package Model.FamilyTree;

import Model.FamilyTree.FileHandler.FileHandler;
import Model.FamilyTree.iterators.FamilyTreeIterator;
import Model.Human.Human;
import Model.Human.comparators.HumanComparatorByAge;
import Model.Human.comparators.HumanComparatorByCountOfChildren;
import Model.Human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T> {

    protected List<T> familyTree;
    FileHandler fileHandler;

    public FamilyTree(){
        familyTree = new ArrayList<>();
        fileHandler = new FileHandler();
    }

    public void addCreatureToFamilyTree(T creature){
        familyTree.add(creature);

    }

    public List<T> getFamilyTree(){
        return familyTree;
    }

    public int getFamilyTreeSize(){
        return familyTree.size();
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

    public void removeHumanFromFamilyTree(Human human){
        familyTree.remove(human);
    }


    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(familyTree);
    }
}
