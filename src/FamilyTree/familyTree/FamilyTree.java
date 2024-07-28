package FamilyTree.familyTree;

import FamilyTree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humanId;
    private List<Human> members;

    private static final long serialVersionUID = 1L;

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
            if (human.getFather() != null && members.contains(human.getFather())) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null && members.contains(human.getMother())) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return true;
    }
    public Human getMemberByName(String name) {
        for (Human member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
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
        if (person.getMother() != null) {
            for (Human child : person.getMother().getChildren()) {
                if (!child.equals(person) && !siblings.contains(child)) {
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