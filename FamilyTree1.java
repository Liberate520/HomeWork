package PR.hW1Golubev;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree1 {
    private Map<Human1, List<Human1>> parentChildMap;

    public FamilyTree1() {
        parentChildMap = new HashMap<>();
    }

    public void addParentChildRelationship(Human1 parent, Human1 child) {
        parentChildMap.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
    }

    public List<Human1> getChildren(Human1 parent) {
        return parentChildMap.getOrDefault(parent, new ArrayList<>());
    }

    public List<Human1> getSiblings(Human1 person) {
        List<Human1> siblings = new ArrayList<>();
        for (Map.Entry<Human1, List<Human1>> entry : parentChildMap.entrySet()) {
            if (entry.getValue().contains(person)) {
                for (Human1 sibling : entry.getValue()) {
                    if (!sibling.equals(person) && !siblings.contains(sibling)) {
                        siblings.add(sibling);
                    }
                }
            }
        }
        return siblings;
    }
}