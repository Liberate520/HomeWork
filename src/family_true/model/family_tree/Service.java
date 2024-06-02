/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class Service
 * @version v1.0
 */

package family_true.model.family_tree;

import family_true.api.Externalizable;
import family_true.impl.FileHandler;
import family_true.model.builder.FamilyTreeBuilder;
import java.util.List;

public class Service<T extends Entity<T>> {

    private FamilyTreeGroup<T> familyTreeGroup;
    private FamilyTreeBuilder familyTreeBuilder;
    private Externalizable external;

    public Service() {
        this.familyTreeGroup = new FamilyTreeGroup();
        this.familyTreeBuilder = new FamilyTreeBuilder();
        this.external = new FileHandler();
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
        List<FamilyTree<T>> familyTreeList = familyTreeGroup.getFamilyTreeList();
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

    public Entity findEntityById(long id) {
        return familyTreeGroup.findEntityById(id);
    }

    public void sortFamilyTreeById() {
        familyTreeGroup.sortFamilyTreeById();
    }

    public void sortFamilyTreeById(List<FamilyTree<T>> familyTrees) {
        familyTreeGroup.sortFamilyTreeById(familyTrees);
    }

    public void sortFamilyTreesEntitiesById() {
        familyTreeGroup.sortFamilyTreesEntitiesById();
    }

    public void sortFamilyTreesEntitiesById(List<FamilyTree<T>> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesById(familyTrees);
    }

    public void sortFamilyTreesEntitiesByBirthDay() {
        familyTreeGroup.sortFamilyTreesEntitiesByBirthDay();
    }

    public void sortFamilyTreesEntitiesByBirthDay(List<FamilyTree<T>> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesByBirthDay(familyTrees);
    }

    public void sortFamilyTreesEntitiesByLastName() {
        familyTreeGroup.sortFamilyTreesEntitiesByLastName();
    }

    public void sortFamilyTreesEntitiesByLastName(List<FamilyTree<T>> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesByLastName(familyTrees);
    }

    public void exportList() {
        external.writeAllExternal(getFamilyTreeGroup().getFamilyTreeList());
    }

    public void importList() {
        List<FamilyTree> familyTreeList = external.readExternal();
        System.out.println(familyTreeList.toString());
        getFamilyTreeGroup().getFamilyTreeList().addAll(familyTreeList);
    }
}
