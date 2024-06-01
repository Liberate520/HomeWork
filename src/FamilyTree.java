import java.util.ArrayList;
import java.util.List;

class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }

    public Human getHumanByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getChildrenOf(Human human) {
        return human.getChildren();
    }

    public void setPeople(List<Human> peopleFromFile) {
        this.humanList = peopleFromFile;
    }

    public List<Human> getPeople() {
        return humanList;
    }
}