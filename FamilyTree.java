package homeWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Iterable<E> {
    private long idForGen;
    private final List<E> memberList;

    public FamilyTree(List<E> memberList) {
        this.memberList = memberList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(E member) {
        if (member == null) {
            return false;
        }
        if (!memberList.contains(member)) {
            memberList.add(member);
            member.setId(idForGen++);

            addToParents(member);
            addToChildren(member);

            return true;
        }
        return false;
    }

    private void addToParents(E member) {
        for (E parent : member.getParents()) {
            parent.addChild(member);
        }
    }

    private void addToChildren(E member) {
        for (E child : member.getChildren()) {
            child.addParent(member);
        }
    }

    public List<E> getSiblings(long id) {
        E member = getById(id);
        if (member == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : member.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(member)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E member : memberList) {
            if (member.getName().equals(name)) {
                res.add(member);
            }
        }
        return res;
    }

    public boolean setWedding(E member1, E member2) {
        if (member1.getSpouse() == null && member2.getSpouse() == null) {
            member1.setSpouse(member2);
            member2.setSpouse(member1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(E member1, E member2) {
        if (member1.getSpouse() != null && member2.getSpouse() != null) {
            member1.setSpouse(null);
            member2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long memberId) {
        if (checkId(memberId)) {
            E member = getById(memberId);
            return memberList.remove(member);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < idForGen && id >= 0;
    }

    public E getById(long id) {
        if (checkId(id)) {
            for (E member : memberList) {
                if (member.getId() == id) {
                    return member;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(memberList.size());
        sb.append(" объектов: \n");
        for (E member : memberList) {
            sb.append(member.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return memberList.iterator();
    }
}
