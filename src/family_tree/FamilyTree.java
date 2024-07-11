package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Human human) {
        members.add(human);
    }

    public Human findMemberByName(String name) {
        for (Human member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public List<Human> getChildrenOf(Human parent) {
        return parent.getChildren();
    }

    public List<Human> getMembers() {
        return members;
    }
}
