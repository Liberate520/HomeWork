package src;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree {
    private Map <String, Human> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(Human member) {
        members.put(member.getName(), member);
    }

    public Human getMember (String name) {
        return members.get(name);
    }
    public void printTree() {
        for (Human member : members.values()) {
            System.out.println(member);
        }

}
}
