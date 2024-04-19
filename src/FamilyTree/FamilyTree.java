package FamilyTree;

import Human.Comparators.DateOfBirthComparator;
import Human.Comparators.NameComparator;
import Human.Human;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T> {
    private List<T> ListOfFamily;

    public FamilyTree(){
        ListOfFamily = new ArrayList<>();
    }

    public boolean addMembertoTree (T Member) {
        if (!ListOfFamily.contains(Member)){
            ListOfFamily.add(Member);
            addMembertoParents(Member);
            addMembertoChild(Member);
        }
        return true;
    }

    private boolean addMembertoChild(FamilyMember Member) {
        for(FamilyMember child: Member.getChildrenList()){
            child.addParents(Member);
        }
        return true;
    }

    private void addMembertoParents(FamilyMember Member) {
        for(FamilyMember parent: Member.getParents()){
            parent.addChildren(Member);
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном дереве сейчас: ");
        sb.append(ListOfFamily.size()).append(" Чел."+"\n");
        for (T Member: ListOfFamily) {
            sb.append(Member);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ListOfFamily.iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    public void sortByDateOfBirth(){
        Collections.sort(ListOfFamily, new DateOfBirthComparator());

    }

    public void sortByName(){
        Collections.sort(ListOfFamily, new NameComparator());

    }
}


