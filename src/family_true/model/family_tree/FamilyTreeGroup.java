/**
 * @author Ostrovskiy Dmitriy
 * @created 27.05.2024
 * class FamilyTreeGroup
 * @version v1.0
 */

package family_true.model.family_tree;

import family_true.model.family_tree.defalt_comporator.ComparatorIndexId;
import family_true.model.family_tree.iterator.FamilyTreeIterator;
import family_true.model.human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeGroup<T extends Entity<T>> implements Iterable<FamilyTree<T>>{

    private List<FamilyTree<T>> familyTreeList;

    public FamilyTreeGroup() {
        this.familyTreeList = new ArrayList<>();
    }

    public List<FamilyTree<T>> getFamilyTreeList() {
        return familyTreeList;
    }

    public void setFamilyTreeList(List<FamilyTree<T>> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    public Entity findEntityById(long id) {
        for (FamilyTree familyTree : familyTreeList) {
            Entity entity = familyTree.getEntityById(id);
            if (entity != null) {
                return entity;
            }
        }
        return null;
    }

    public void sortFamilyTreeById() {
        sortFamilyTreeById(familyTreeList);
    }

    public void sortFamilyTreeById(List<FamilyTree<T>> familyTrees) {
        familyTrees.sort(new ComparatorIndexId<>());
    }

    public void sortFamilyTreesEntitiesById() {
        sortFamilyTreesEntitiesById(familyTreeList);
    }

    public void sortFamilyTreesEntitiesById(List<FamilyTree<T>> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.sortEntitiesById();
        }
    }

    public void sortFamilyTreesEntitiesByBirthDay() {
        sortFamilyTreesEntitiesByBirthDay(familyTreeList);
    }

    public void sortFamilyTreesEntitiesByBirthDay(List<FamilyTree<T>> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.sortEntitiesByBirthDay();
        }
    }

    public void sortFamilyTreesEntitiesByLastName() {
        sortFamilyTreesEntitiesByLastName(familyTreeList);
    }

    public void sortFamilyTreesEntitiesByLastName(List<FamilyTree<T>> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.sortEntitiesByLastName();
        }
    }

    public String getInfo() {
        if (familyTreeList.size() == 0 || familyTreeList.size() == 1 && familyTreeList.get(0).getEntities().size() == 0) {
            return "Список пуст";
        }
        return familyTreeList.toString();
    }

    @Override
    public Iterator<FamilyTree<T>> iterator() {
        return new FamilyTreeIterator<T>(familyTreeList);
    }
}
