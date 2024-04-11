package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Children> childrenList;

    public FamilyTree() {
        this.childrenList = new ArrayList<>();
    }

    public void addPerson(Human person, Human parent1, Human parent2) {
        Children child = new Children(person);
        child.addParent(parent1.getName(), parent1);
        child.addParent(parent2.getName(), parent2);
        childrenList.add(child);
    }

    public void addPerson(Human person, Human parent) {
        Children child = new Children(person);
        child.addParent(parent.getName(), parent);
        childrenList.add(child);
    }

    public void addPerson(Human person) {
        childrenList.add(new Children(person));
    }

    public void addChild(Human child, Human parent1, Human parent2) {
        Children children = new Children(child);
        children.addParent(parent1.getName(), parent1);
        children.addParent(parent2.getName(), parent2);
        childrenList.add(children);
    }

    public void displayFamilyTree() {
        System.out.println("Family Tree:");
        for (Children children : childrenList) {
            if (children.getParents().isEmpty()) {
                System.out.println("Unknown -> " + children.getChild().getName());
            } else {
                for (String parentName : children.getParents().keySet()) {
                    System.out.println(parentName + " -> " + children.getChild().getName());
                }
            }
        }
    }
}
