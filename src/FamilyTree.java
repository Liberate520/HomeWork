package src;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree implements Serializable{
    private Map <String, Human> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }
    //  add member to family tree
    public void addMember(Human member) {
        members.put(member.getName(), member);
    }
    // find member by name
    public Human getMember (String name) {
        return members.get(name);
    }
    // print entire family tree
    public void printTree() {
        for (Human member : members.values()) {
            System.out.println(member);
        }
}
}
