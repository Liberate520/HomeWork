import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;

    public void SetFamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void add(List<Human> familyTree, Human human) {
        familyTree.add(human);
    }

    public String getFamilyTree() {
        for (Human human : familyTree) {
            return human.getInfo();
        }
        return "";
    }
}