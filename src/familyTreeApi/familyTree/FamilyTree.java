package familyTreeApi.familyTree;

import familyTreeApi.member.Member;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.*;

public class FamilyTree<E extends Member> implements Serializable, FTree<E> {
    private String name;
    private String typeMember;
    private List<E> members;

    private List<E> tempMembers;

    public FamilyTree(String name, String typeMember) {
        this.setName(name);
        this.setTypeMember(typeMember);
        this.members = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeMember(String typeMember) {
        this.typeMember = typeMember;
    }

    public String getName() {
        return this.name;
    }

    public String getTypeMember() {
        return this.typeMember;
    }

    public List<E> getMembers() {
        return this.members;
    }

    private String getSpace(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 30 - str.length(); i++) {
            result.append(" ");
        }
        return result.toString();
    }

    private String getSpaces(int iter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < iter; i++) {
            result.append(String.format("%s|", getSpace("")));
        }
        return result.toString();
    }

    public <E extends Member> boolean addMember(E member) {
        return addMember(member, false);
    }

    public <E extends Member> boolean addMember(E member, boolean isAddAllChildren) {
        if (!this.hasMember(member)) {
            if (isAddAllChildren) {
                this.addChildren(member);
            }
            return ((List<E>) this.getMembers()).add(member);
        }
        return false;
    }

    private <E extends Member> void addChildren(E member) {
        if (this.hasMember(member)) {
            if (member.countChildren() != 0) {
                for (E pers : (List<E>) member.getChildren()) {
                    this.addMember(pers, true);
                }
            }
        } else {
            this.addMember(member, true);
        }
    }

    private <E extends Member> boolean hasMember(E member) {
        return this.getMembers().contains(member);
    }

    public E findMember(String name) {
        for (E member : this.getMembers()) {
            if (member.getNameString().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new MemberIterator(members);
    }

    public String printAllInfo() {
        StringBuilder result = new StringBuilder();
        for (E member : this.getMembers()) {
            result.append(member.print() + "\n");
        }
        return result.toString();
    }

    public String printTree() {
        StringBuilder result = new StringBuilder();
        tempMembers = new ArrayList<>();
        result.append(String.format("Members of family %s\n", this.getName()));
        for (E member : this.getMembers()) {
            if (!tempMembers.contains(member)) {
                result = printTree(result, member);
            }
        }
        return result.toString();
    }

    public StringBuilder printTree(StringBuilder result, E member) {
        while (((List<E>) member.getParents()).size() > 0) {
            for (E m : (List<E>) member.getParents()) {
                if (members.contains(m)) {
                    member = m;
                }
            }
        }
        result = printTree(result, member, 1);
        return result;
    }

    private StringBuilder printTree(StringBuilder result, E member, int iter) {
        String marriedName = "";
        if (member.getMarried() != null) {
            ((List<E>) tempMembers).add((E) member.getMarried());
            marriedName = "+" + member.getMarried().print();
        }
        result.append(String.format("%s%s%s|", member.print(), marriedName, getSpace(member.print() + marriedName)));
        ((List<E>) tempMembers).add(member);
        if (member.countChildren() > 0) {
            ListIterator<E> children = ((List<E>) member.getChildren()).listIterator();
            while (children.hasNext()) {
                if (children.nextIndex() > 0) result.append(String.format("%s", getSpaces(iter)));
                result = printTree(result, children.next(), iter + 1);
            }
        } else {
            result.append("\n");
        }
        return result;
    }
}