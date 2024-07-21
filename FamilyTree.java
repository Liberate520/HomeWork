package Family_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FamilyTree {

    private List<Human> family;

    public FamilyTree() {
        this.family = new LinkedList<>();
    }

    public void addMember(Human human) {
        family.add(human);
    }
    public void addMembers(Human human, Human human1) {
        family.add(human);
        family.add(human1);
    }

    /**
     * 
     * @param person - человек, от которого мы ищем предков
     * @param generations - поколение, до которого мы ищем предков
     * @return - список предков
     */
    public List<Human> getAncestors(Human person, int generations) {
        List<Human> ancestors = new ArrayList<>();
        findAncestors(person, generations, ancestors);
        return ancestors;
    }

    public void findAncestors(Human person, int generations, List<Human> ancestors) {
        if (generations == 0 || person.getParents().isEmpty()) {
            return;
        }
        for (Human parent : person.getParents()) {
            ancestors.add(parent);
            findAncestors(parent, generations - 1, ancestors);
        }
    }
}
