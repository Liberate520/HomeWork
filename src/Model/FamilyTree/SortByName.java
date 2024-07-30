package Model.FamilyTree;

import Model.Human.Human;
import Model.Human.HumanComparatorbyName;

import java.util.Comparator;
import java.util.List;

public class SortByName implements Sorter<Human>{
    @Override
    public void Sort(List<Human> familyTree) {
        familyTree.sort(new HumanComparatorbyName<>());
    }
}
