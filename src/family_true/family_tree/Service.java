/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class Service
 * @version v1.0
 */

package family_true.family_tree;

import family_true.api.Entity;
import family_true.builder.FamilyTreeBuilder;
import java.util.List;

public class Service<T extends Entity> {

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

    public void sortFamilyTreesHumansById() {
        familyTreeGroup.sortFamilyTreesHumansById();
    }

    public void sortFamilyTreesHumansById(List<FamilyTree> familyTrees) {
        familyTreeGroup.sortFamilyTreesHumansById(familyTrees);
    }

    public void sortFamilyTreesHumansByBirthDay() {
        familyTreeGroup.sortFamilyTreesHumansByBirthDay();
    }

    public void sortFamilyTreesHumansByBirthDay(List<FamilyTree> familyTrees) {
        familyTreeGroup.sortFamilyTreesHumansByBirthDay(familyTrees);
    }

    public void sortFamilyTreesHumansByLastName() {
        familyTreeGroup.sortFamilyTreesHumansByLastName();
    }

    public void sortFamilyTreesHumansByLastName(List<FamilyTree> familyTrees) {
        familyTreeGroup.sortFamilyTreesHumansByLastName(familyTrees);
    }
}
