package familytree.service;

import java.util.HashMap;
import java.util.Map;

public class MemberService {
    private Map<String, Member> familyTree = new HashMap<>();

    public void addMember(String name, String gender) {
        if (!familyTree.containsKey(name)) {
            familyTree.put(name, new Member(name, gender));
        }
    }

    public Member findMember(String name) {
        return familyTree.get(name);
    }

    public Map<String, Member> getFamilyTree() {
        return familyTree;
    }
}
