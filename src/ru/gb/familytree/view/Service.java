package ru.gb.familytree.view;

import ru.gb.familytree.model.FamilyTree;
import ru.gb.familytree.model.HumanInfo;

import java.util.List;

public class Service {
    private FamilyTree<HumanInfo> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public void addMember(HumanInfo member) {
        familyTree.addMember(member);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByDob() {
        familyTree.sortByDob();
    }

    public List<HumanInfo> getMembers() {
        return familyTree.getMembers();
    }

    public HumanInfo findPersonByName(String name) {
        return familyTree.getMembers().stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}