import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FamilyTree<T extends Human> implements Serializable, Iterable<T>{
    private List<T> memberList;

    public FamilyTree() {
        this.memberList = new ArrayList<>();
    }

    public FamilyTree(List<T> memberList) {
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
        for (Human parent: member.getParents()) {
            parent.addChild(member);
        }
    }

    private void addToChildren(T member) {
        for (Human child: member.getChildren()) {
            child.addParent(member);
        }
    }

    public Human getHumanByName(String name) {
        for (T member : memberList) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<Human> getChildrenOf(T member) {
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