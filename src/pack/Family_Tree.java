package pack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family_Tree implements HumanObserver, Serializable {

    private static final long serialVersionUID = 1L;
    protected List<Human> familyTree;

    public Family_Tree() {
        familyTree = new ArrayList<>();
        Human.addObserver(this);
    }

    protected void addHumanToFamilyTree(Human human) {
        familyTree.add(human);
    }

    protected List<Human> getFamilyTree() {
        return familyTree;
    }

    public void printFamilyTree() {
        for (Human human : familyTree) {
            System.out.println(human.getInfo());
        }
    }

    @Override
    public void onHumanCreated(Human human) {
        addHumanToFamilyTree(human);
    }
}
