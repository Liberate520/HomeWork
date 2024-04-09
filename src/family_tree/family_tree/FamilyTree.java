package family_tree.family_tree;

import family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Human member) {
        members.add(member);
    }

    public List<Human> getMembers() {
        return members;
    }

    // Другие методы для работы с деревом семьи
}
