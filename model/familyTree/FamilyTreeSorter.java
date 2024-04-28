package homeWork.model.familyTree;

import java.util.List;

import homeWork.model.human.humanComparator.HumanComparatorByDate;
import homeWork.model.human.humanComparator.HumanComparatorByName;

public class FamilyTreeSorter<T extends FamTree>{
    private List<T> list;

    public FamilyTreeSorter(FamilyTree<T> familyTree) {
        this.list = familyTree.getList();
    }

    public void sortbyName(){
        list.sort(new HumanComparatorByName<>());
    }

    public void sortbyDate(){
        list.sort(new HumanComparatorByDate<>());
    }
}