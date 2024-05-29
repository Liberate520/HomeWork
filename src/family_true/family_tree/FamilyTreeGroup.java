/**
 * @author Ostrovskiy Dmitriy
 * @created 27.05.2024
 * class FamilyTreeGroup
 * @version v1.0
 */

package family_true.family_tree;

import family_true.api.Entity;
import family_true.family_tree.defalt_comporator.ComparatorIndexId;
import family_true.family_tree.iterator.FamilyTreeIterator;
import family_true.human.Human;
import family_true.human.comparator.ComparatorByBirthDay;
import family_true.human.comparator.ComparatorByLastName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeGroup implements Iterable<FamilyTree>{

    private List<FamilyTree> familyTreeList;

    public FamilyTreeGroup() {
        this.familyTreeList = new ArrayList<>();
    }

    public List<FamilyTree> getFamilyTreeList() {
        return familyTreeList;
    }

    public void setFamilyTreeList(List<FamilyTree> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    public void sortFamilyTreeById() {
        sortFamilyTreeById(familyTreeList);
    }

    public void sortFamilyTreeById(List<FamilyTree> familyTrees) {
        familyTrees.sort(new ComparatorIndexId<>());
    }

    public void sortFamilyTreesHumansById() {
        sortFamilyTreesHumansById(familyTreeList);
    }

    public void sortFamilyTreesHumansById(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.getEntities().sort(new ComparatorIndexId<>());
        }
    }

    public void sortFamilyTreesHumansByBirthDay() {
        sortFamilyTreesHumansByBirthDay(familyTreeList);
    }

    public void sortFamilyTreesHumansByBirthDay(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.getEntities().sort(new ComparatorByBirthDay<Human>());
        }
    }

    public void sortFamilyTreesHumansByLastName() {
        sortFamilyTreesHumansByLastName(familyTreeList);

    }

    public void sortFamilyTreesHumansByLastName(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.getEntities().sort(new ComparatorByLastName<Human>());
        }
    }

    @Override
    public Iterator<FamilyTree> iterator() {
        return new FamilyTreeIterator(familyTreeList);
    }
}
