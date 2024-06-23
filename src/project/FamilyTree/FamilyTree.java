package project.FamilyTree;

import java.util.List;

import project.Members.TreeMember;

public interface FamilyTree<T extends TreeMember> {
    boolean addMember(T member);
    T getHumanByName(String name);
    List<TreeMember> getChildrenOf(T member);
    List<T> getPeople();
    void sortByName();
    void sortByBirthDate();
    List<String> getMemberDescriptions();
}