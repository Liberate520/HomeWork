package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.comparators.ComparatorByAge;
import ru.gb.family_tree.model.human.comparators.ComparatorByName;
import ru.gb.family_tree.model.family_tree.iterators.FamilyTreeIterator;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import java.util.Iterator;


public class FamilyTree<E extends FamilyTreeElement<E>> implements Serializable, Iterable<E> {

    private long MemberId;
    private final List<E> MemberList;


    public FamilyTree() {
        this.MemberList = new ArrayList<>();
    }


    public boolean addMember(E member) {
        if (member == null) {
            return false;
        }
        if (!MemberList.contains(member)) {
            MemberList.add(member);
            member.setId(MemberId++);

            addParentsRelations(member);
            addChildrenRelations(member);

            return true;
        }
        return false;
    }


    private void addParentsRelations(E member) {
        E mother = member.getMother();
        if (mother != null) {
            mother.addChild(member);
        }

        E father = member.getFather();
        if (father != null) {
            father.addChild(member);
        }
    }


    private void addChildrenRelations(E member) {
        if (member.getChildren().size() > 0) {
            for (E child : member.getChildren()) {
                if (member.getGender() == Gender.female) {
                    child.setMother(member);
                } else {
                    child.setFather(member);
                }
            }
        }
    }


    public E findById(long id) {
        for (E member: MemberList) {
            if (member.getId() == id) {
//                System.out.println(member);
                return member;
            }
        }
        return null;
    }


    public List<E> findByName(String name) {
        List<E> res = new ArrayList<>();
        for (E member: MemberList) {
            if (member.getName().equalsIgnoreCase(name)) {
                res.add(member);
            }
        }
        for (E member : res) {
            System.out.println(member);
        }
        return res;
    }


    public boolean checkById(int id) {
        return MemberList.contains(findById(id));
    }


    public String getAboutFamily() {
        StringBuilder sb = new StringBuilder();
        sb.append("Members in family: ");
        sb.append(MemberList.size() + "\n\n------------\nThey are:\n\n");
        for (E member : MemberList) {
            sb.append(member);
            sb.append("\n");
            sb.append("-----------\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return getAboutFamily();
    }


    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(MemberList);
    }


    public void sortByAge() {
        MemberList.sort(new ComparatorByAge<>());
    }


    public void sortByName() {
        MemberList.sort(new ComparatorByName<>());
    }

}


//---------------------------------------------------------
