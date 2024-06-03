/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class Service
 * @version v1.0
 */

package family_true.family_tree;

import family_true.builder.FamilyTreeBuilder;
import java.util.List;

public class Service<T extends Entity<T>> {

    private FamilyTreeGroup familyTreeGroup;

    private FamilyTreeBuilder familyTreeBuilder;

    public Service() {
        this.familyTreeGroup = new FamilyTreeGroup();
        this.familyTreeBuilder = new FamilyTreeBuilder();
    }

    public FamilyTreeGroup getFamilyTreeGroup() {
        return familyTreeGroup;
    }

    public FamilyTree addHumanToNewTree(T entity) {
        return addHumanByTree(entity, true);
    }

    public FamilyTree addHumanToLastTree(T entity) {
        return addHumanByTree(entity, familyTreeGroup.getFamilyTreeList().size() == 0);
    }

    public FamilyTree addHumanByTree(T entity, boolean isNewTree) {
        List<FamilyTree> familyTreeList = familyTreeGroup.getFamilyTreeList();
        FamilyTree tree;
        if (isNewTree) {
            tree = familyTreeBuilder.build(entity);
            familyTreeList.add(tree);
        } else {
            tree = familyTreeList.get(familyTreeList.size() - 1);
            familyTreeBuilder.getEntityBuilder().build(entity);
            familyTreeList.get(tree.getIndexId()).addEntity(entity);
        }
        return tree;
    }

    public void sortFamilyTreeById() {
        familyTreeGroup.sortFamilyTreeById();
    }

    public void sortFamilyTreeById(List<FamilyTree> familyTrees) {
        familyTreeGroup.sortFamilyTreeById(familyTrees);
    }

    public void sortFamilyTreesEntitiesById() {
        familyTreeGroup.sortFamilyTreesEntitiesById();
    }

    public void sortFamilyTreesEntitiesById(List<FamilyTree> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesById(familyTrees);
    }

    public void sortFamilyTreesEntitiesByBirthDay() {
        familyTreeGroup.sortFamilyTreesEntitiesByBirthDay();
    }

    public void sortFamilyTreesEntitiesByBirthDay(List<FamilyTree> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesByBirthDay(familyTrees);
    }

    public void sortFamilyTreesEntitiesByLastName() {
        familyTreeGroup.sortFamilyTreesEntitiesByLastName();
    }

    public void sortFamilyTreesEntitiesByLastName(List<FamilyTree> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesByLastName(familyTrees);
    }
}
