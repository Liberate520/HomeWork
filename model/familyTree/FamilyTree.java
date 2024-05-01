package homeWork.model.familyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import homeWork.model.human.humanComparator.HumanComparatorByDate;
import homeWork.model.human.humanComparator.HumanComparatorByName;

public class FamilyTree<T extends FamTree> implements Serializable, Iterable<T>{
    private List<T> list;
    
    public FamilyTree() {
        this.list = new ArrayList<>();
    }

    public void addHuman(T name) {
        list.add(name);
    }

    public List<T> getList() {
        return list;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new FamilyTreeIterator<>(list);
    }

    public void sortbyName(){
        list.sort(new HumanComparatorByName<>());
    }

    public void sortbyDate(){
        list.sort(new HumanComparatorByDate<>());
    }
}
