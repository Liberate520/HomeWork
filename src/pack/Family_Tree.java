package pack;

import java.util.ArrayList;
import java.util.List;

public class Family_Tree {

    private List<Human> familyTree;

    public Family_Tree() {
        this.familyTree = new ArrayList<>();
    }


    protected void addHumanToFamilyTree(Human human) {
        this.familyTree.add(human);
    }

    protected List<Human> getFamilyTree(){
        return familyTree;
    }


    public void printFamilyTree() {
        for (Human human : familyTree) {
            human.getInfo();
        }
    }
    public short getId(Human human) {
        return (short) familyTree.indexOf(human);
    }
}






