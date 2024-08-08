import java.util.List;

public class Plant {
    private FamilyTree familyTree;

    public Plant (FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public List<Human> getChildren(String name) {
        Human human = familyTree.findHuman(name);
        if (human!= null) {
            return human.getChildren();
        }
        return null;
    }

    public Human[] getParents(String name) {
        Human human = familyTree.findHuman(name);
        if (human != null) {
            return new Human[]{human.getFather(), human.getMother()};
        }
        return null;
    }

    public List<Human> getSiblings(String name) {
        Human human = familyTree.findHuman(name);
        if (human != null) {
            Human father = human.getFather();
            Human mother = human.getMother();
            if (father != null) {
                return father.getChildren().stream()
                        .filter(child -> !child.equals(human))
                        .toList();
            } else if (mother != null) {
                return mother.getChildren().stream()
                        .filter(child -> !child.equals(human))
                        .toList();
            }
        }
        return null;
    }
}
