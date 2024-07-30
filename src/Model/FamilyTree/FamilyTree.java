package Model.FamilyTree;

import java.io.Serializable;
import java.util.*;
//import Model.Dogs.Human.HumanIterator;
import Model.Human.HumanComparatorbyAmountOfChildren;

public class FamilyTree<E extends FamilyMember<E>> implements Serializable, Iterable<E> {
    private final List<E> listOfFamily;

    public FamilyTree(){
        listOfFamily = new ArrayList<>();
    }

    public FamilyTree(List<E> listOfFamily) {
        this.listOfFamily = listOfFamily;
    }

    public void addHumantoTree(E member) {
        if (!listOfFamily.contains(member)){
            listOfFamily.add(member);
            addHumantoChildListofParents(member);
            makeHumanaParentofChildList(member);
        }
    }

    private void makeHumanaParentofChildList(E member) {
        for(FamilyMember child: member.getChildrensList()){
            child.addParentstoFamilyMember(member);
        }
    }

    private void addHumantoChildListofParents(E member) {
        for(FamilyMember parent: member.getParentsofFamilyMember()){
            parent.addChildrentoFamilyMember(member);
        }
    }

    public boolean addSpouseToFamilyMember(E member, E spouse){
        if (member == null || spouse == null || member.equals(spouse)) {
            return false;
        }
        member.setSpouse(spouse);
        spouse.setSpouse(member);
        return true;
    }

    public E getbyId(Integer id) {
        for (E member: listOfFamily){
            if (member.getId().equals(id)){
                return member;
            }
        }
        System.out.println("Члена семьи с таким id нет");
        return null;
    }

    public List<E> getListOfFamily() {
        return listOfFamily;
    }

//    public void sortByName(){
//
//        listOfFamily.sort(null);
//    }
//
//    public void sortByAmountOfChildren(){
//        listOfFamily.sort(new HumanComparatorbyAmountOfChildren<>());
//    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном дереве сейчас: ");
        sb.append(listOfFamily.size()).append(" Чел."+"\n");
        for (E human: listOfFamily) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return listOfFamily.iterator() ;
    }
}


