package Model.FamilyTree;

import Model.Human.Human;
import Model.Human.HumanComparatorbyAmountOfChildren;
import Model.Human.HumanComparatorbyName;

import java.util.List;

public class SortByAmountOfChildren implements Sorter<Human>{
    @Override
    public void Sort(List<Human> familyTree) {
        familyTree.sort(new HumanComparatorbyAmountOfChildren<>());
    }
}

