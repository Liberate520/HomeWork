package src.Model.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import src.Model.Human.HumanComparatorByAge;
import src.Model.Human.HumanComparatorByChildrenAmount;
import src.Model.Human.HumanComparatorByName;

public class FamilyTree<E extends FamilyMember<E>> implements Serializable, Iterable <E> {
    private List <E> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(E member) {
        members.add(member);
    }

    public E getMember (String name) {
        for (E member: members) {
            if(member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }    

    public void sortByName() {
        Collections.sort(members, new HumanComparatorByName<>());
    }

    public void sortByBirthday(){
        Collections.sort(members, new HumanComparatorByAge<>());
    }

    public void sortByChildren(){
        Collections.sort(members, new HumanComparatorByChildrenAmount<>());
    }

    public String GetFamilyInfo(){
        StringBuilder sb = new StringBuilder();
        for (E member: members){
            sb.append(member);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(members);        
    }  
}
