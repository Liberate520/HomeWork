package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int countPeople;
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) { this.humanList = humanList;}
    public FamilyTree() {this(new ArrayList<>());}

    public boolean add(Human human){
        if (human==null) return false;
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(countPeople++);
            addToParents(human);
            addToChildren(human);
            return true;

        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

}
