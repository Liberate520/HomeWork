package FamilyTree.familyTree;

import FamilyTree.human.Human;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long humanId;
    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public boolean addMember(Human human) {
        if (human == null) {
            return false;
        }
        if (!members.contains(human)){
            members.add(human);
            human.setId(humanId++);

            return true;
        }
        return true;
    }

    public List<Human> getChildren(Human parent) {
        return parent.getChildren();
    }

    public List<Human> getSiblings(Human person) {
        List<Human> siblings = new ArrayList<>();
        if (person.getFather() != null) {
            for (Human child : person.getFather().getChildren()) {
                if (!child.equals(person)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public Human getSpouse(Human person) {
        return person.getSpouse();
    }

    public List<Human> getAncestors(Human person) {
        List<Human> ancestors = new ArrayList<>();
        if (person.getFather() != null) {
            ancestors.add(person.getFather());
            ancestors.addAll(getAncestors(person.getFather()));
        }
        if (person.getMother() != null) {
            ancestors.add(person.getMother());
            ancestors.addAll(getAncestors(person.getMother()));
        }
        return ancestors;
    }

    // Дополнительные методы для исследования добавлю позже здесь
}