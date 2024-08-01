package ru.gb2.family_tree7.model.family_tree;

import ru.gb2.family_tree7.model.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private final List<Human> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMember(Human human) {
        members.add(human);
    }

    public List<Human> getMembers() {
        return members;
    }

    public Human findMember(String name, LocalDate birthDate) {
        for (Human member : members) {
            if (member.getName().equalsIgnoreCase(name) && member.getBirthDate().equals(birthDate)) {
                return member;
            }
        }
        return null;
    }
}
