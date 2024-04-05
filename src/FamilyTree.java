import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree;

    public void SetFamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHumanToFamilyTree(Human human) {
        familyTree.add(human);
    }

    public void getFamilyTree() {
        for (Human human : familyTree) {
            human.getInfo();
            System.out.println("\n");
        }
    }
}