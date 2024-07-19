package Part3_OOP.Seminar1.Family_tree;

import java.util.LinkedList;

public class FamilyTree {

    private LinkedList<Human> family;

    public FamilyTree() {
        this.family = new LinkedList<>();
    }

    public void addMember(Human human) {
        family.add(human);
    }
    /**
     * 
     * @param person - человек, от которого мы ищем предков
     * @param generations - поколение, до которого мы ищем предков
     * @return - список предков
     */
    public LinkedList<Human> getAncestors(Human person, int generations) {
        LinkedList<Human> ancestors = new LinkedList<>();
        findAncestors(person, generations, ancestors);
        return ancestors;
    }

    private void findAncestors(Human person, int generations, LinkedList<Human> ancestors) {
        if (generations == 0 || person.getParents().isEmpty()) {
            return;
        }
        for (Human parent : person.getParents()) {
            ancestors.add(parent);
            findAncestors(parent, generations - 1, ancestors);
        }
    }
}
