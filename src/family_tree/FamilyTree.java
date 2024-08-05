package family_tree;

import java.util.*;

public class FamilyTree {
    private HashSet<Human> fTree;

    public FamilyTree() {
        this.fTree = new HashSet<>();
    }

    public HashSet<Human> getfTree() {
        return fTree;
    }

    public void addRecord(Human human, Human... parents){
            fTree.add(human);
            if (parents.length > 0) {
                Human mother = parents[0];
                mother.addChild(human.getID());
                fTree.add(mother);
                human.setMother(mother.getID());
            }
            if (parents.length > 1) {
                Human father = parents[1];
                father.addChild(human.getID());
                fTree.add(father);
                human.setFather(father.getID());
            }
    }

}
