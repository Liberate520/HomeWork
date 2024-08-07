package family_tree;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable {
    private HashSet<Human> fTree;

    public FamilyTree() {
        this.fTree = new HashSet<>();
    }

    public HashSet<Human> getfTree() {
        return fTree;
    }

    public void addHuman(Human human){
            fTree.add(human);
    }

    public HashSet<Human> findInfoByDocument(String doc) {
        HashSet<Human> result = new HashSet<>();
        for (Human human : fTree) {
            if (human.getDocument().equals(doc)) {
                result.add(human);
            }
        }
        return result;
    }

    public HashSet<Human> findInfoByName(String name) {
        HashSet<Human> result = new HashSet<>();
        for (Human human : fTree) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }






}
