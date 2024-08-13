import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.humans.add(human);
    }


    public List<Human> getChildren(Human parent) {
        return parent.getChildren();
    }

    public void addParentChildRelation(Human parent, Human child) {
        parent.addChild(child);
        if (parent.getGender() == Gender.MALE) {
            child.setFather(parent);
        } else {
            child.setMother(parent);
        }
    }

    public List<Human> getAllHumans() {
        return humans;
    }

    public void printFamilyTree(Human human) {
        printFamilyTree(human, 0, new HashSet<>());
    }

    private void printFamilyTree(Human human, int level, Set<Human> visited) {
        if (human == null || visited.contains(human)) {
            return;
        }

        visited.add(human);

        for (int i = 0; i < level; i++) {
            System.out.print("");
        }
        System.out.println(human);

        printFamilyTree(human.getFather(), level + 1, visited);
        printFamilyTree(human.getMother(), level + 1, visited);

        for (Human child : human.getChildren()) {
            printFamilyTree(child, level + 1, visited);
        }
    }
}