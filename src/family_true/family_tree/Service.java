/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class Service
 * @version v1.0
 */

package family_true.family_tree;

import family_true.builder.FamilyTreeBuilder;
import family_true.human.Human;
import java.util.List;

public class Service {

    private FamilyTreeGroup familyTreeGroup;

    private FamilyTreeBuilder familyTreeBuilder;

    public Service() {
        this.familyTreeGroup = new FamilyTreeGroup();
        this.familyTreeBuilder = new FamilyTreeBuilder();
    }

    public FamilyTreeGroup getFamilyTreeGroup() {
        return familyTreeGroup;
    }

    public FamilyTree addHumanToNewTree(Human human) {
        return addHumanByTree(human, true);
    }

    public FamilyTree addHumanToLastTree(Human human) {
        return addHumanByTree(human, familyTreeGroup.getFamilyTreeList().size() == 0);
    }

    public FamilyTree addHumanByTree(Human human, boolean isNewTree) {
        List<FamilyTree> familyTreeList = familyTreeGroup.getFamilyTreeList();
        FamilyTree tree;
        if (isNewTree) {
            tree = familyTreeBuilder.build(human);
            familyTreeList.add(tree);
        } else {
            tree = familyTreeList.get(familyTreeList.size() - 1);
            familyTreeList.get(tree.getIndexId()).addHuman(familyTreeBuilder.getHumanBuilder().build(human));
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
