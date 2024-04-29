package family_tree.model;

import java.util.*;

public class FamilyTreeModel {
    private FamilyTree<Human> familyTree;

    public FamilyTreeModel() {
        this.familyTree = new FamilyTree<>();
    }

    public void addBeing(Human being) {
        this.familyTree.addBeing(being);
    }

    public List<Human> getSortedTree() {
        List<Human> sortedTree = new ArrayList<>(familyTree.getBeings());
        sortedTree.sort(Comparator.comparing(Human::getName));
        return sortedTree;
    }

    public Human findBeing(String name) {
        for (Human being : familyTree.getBeings()) {
            if (being.getName().equals(name)) {
                return being;
            }
        }
        return null;
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }
}
