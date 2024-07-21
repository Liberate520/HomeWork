package Family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Human> family = new ArrayList<>();

    public void addMember(Human human) {
        family.add(human);
    }

    public void addMembers(Human... humans) {
        for (Human human : humans) {
            family.add(human);
        }
    }

    public List<Human> getFamily() {
        return family;
    }

    public List<Human> getAncestors(Human person, int generations) {
        List<Human> ancestors = new ArrayList<>();
        getAncestorsRecursive(person, generations, ancestors);
        return ancestors;
    }

    private void getAncestorsRecursive(Human person, int generations, List<Human> ancestors) {
        if (generations == 0 || person == null) return;
        if (!person.parents.isEmpty()) {
            ancestors.addAll(person.parents);
            for (Human parent : person.parents) {
                getAncestorsRecursive(parent, generations - 1, ancestors);
            }
        }
    }
}

