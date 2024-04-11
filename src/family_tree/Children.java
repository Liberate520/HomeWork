package family_tree;

import java.util.HashMap;
import java.util.Map;

public class Children {
    private Human child;
    private Map<String, Human> parents;

    public Children(Human child) {
        this.child = child;
        this.parents = new HashMap<>();
    }

    public Human getChild() {
        return child;
    }

    public Map<String, Human> getParents() {
        return parents;
    }

    public void addParent(String parentName, Human parent) {
        parents.put(parentName, parent);
    }
}
