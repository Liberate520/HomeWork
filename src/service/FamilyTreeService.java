package service;

import model.FamilyMember;
import model.FamilyTree;
import model.HumanComparatorByBirthDate;
import model.HumanComparatorByName;

import java.util.Collections;

public class FamilyTreeService <T extends FamilyMember> {

    public void sortByName(FamilyTree<T> familyTree) {
        Collections.sort(familyTree.getMembers(), new HumanComparatorByName<>());
    }

    public void sortByBirthDate(FamilyTree<T> familyTree) {
        Collections.sort(familyTree.getMembers(), new HumanComparatorByBirthDate<>());
    }

}
