package project.FamilyTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import project.Members.TreeMember;

public class FamilyTreeIMPL<T extends TreeMember> implements FamilyTree<T>, Serializable, Iterable<T>{
    private List<T> memberList;

    public FamilyTreeIMPL() {
        this.memberList = new ArrayList<>();
    }

    public FamilyTreeIMPL(List<T> memberList) {
        this.memberList = memberList;
    }

    public boolean addMember(T member) {
        if (member == null) {
            return false;
        }
        if (!memberList.contains(member)){
            memberList.add(member);

            addToParents(member);
            addToChildren(member);

            return true;
        }
        return false;
    }

    private void addToParents(T member) {
        for (TreeMember parent: member.getParents()) {
            parent.addChild(member);
        }
    }

    private void addToChildren(T member) {
        for (TreeMember child: member.getChildren()) {
            child.addParent(member);
        }
    }

    public T getHumanByName(String name) {
        for (T member : memberList) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<TreeMember> getChildrenOf(T member) {
        return member.getChildren();
    }

    public void setPeople(List<T> peopleFromFile) {
        this.memberList = peopleFromFile;
    }

    public List<T> getPeople() {
        return memberList;
    }

    public void sortByName() {
        Collections.sort(memberList, (h1, h2) -> h1.getName().compareTo(h2.getName()));
    }

    public void sortByBirthDate() {
        Collections.sort(memberList, (h1, h2) -> h1.getBirthDate().compareTo(h2.getBirthDate()));
    }

    public List<String> getMemberDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for (T member : this) {
            descriptions.add(member.toString());
        }
        return descriptions;
    }

    @Override
    public Iterator<T> iterator() {
        return memberList.iterator();
    }
}