package family_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class FamilyTree {
    private ArrayList<Human> fTree;

    public FamilyTree(int maxSize) {
        this.fTree = new ArrayList<>();
    }

    public ArrayList<Human> getfTree() {
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
