package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamTreeItem<E>> implements Iterable<E>, Serializable {
    private List<E> familyTreeList = new ArrayList<>();
    private List<Long> emptyIds = new ArrayList<>();


    private void letHumanId(E human) {
        human.setId(human.getCurrentId());
        human.setCurrentId();
    }

    public void addHumansInFamTree(E... human) {
        for (E fam: human) {
            familyTreeList.add(fam);
            if (emptyIds.isEmpty()) {
                letHumanId(fam);
            }
            else {
                fam.setId(emptyIds.get(0));
            }
        }
    }

    public void removeHumansFromFamTree(E... human) {
        for (E fam: human) {
            familyTreeList.remove(fam);
            emptyIds.add(fam.getId());
        }
    }


    public void removeHumanFromFamTree(E... human){
        for (E fam: human) {
            familyTreeList.remove(fam);
        }
    }

    public E findHuman(String firstName){
        for (E el : familyTreeList) {
            if (el.getFirstName().equals(firstName)){
                return el;
            }
        }
        return null;
    }

    public void sortByFirstName(){
        familyTreeList.sort((a1, a2) -> a1.getFirstName().compareTo(a2.getFirstName()));
    }

    public void sortById(){
        familyTreeList.sort((a1, a2) -> (int) (a1.getId() - a2.getId()));
    }

    public void sortByGender(){
        familyTreeList.sort((a1, a2) -> (a1.getGender().compareTo(a2.getGender())));
    }

    public void sortByDob(){
        familyTreeList.sort((a1, a2) -> (a1.getDob().compareTo(a2.getDob())));
    }

    public void sortByDod(){
        familyTreeList.sort((a1, a2) -> (a1.getDod().compareTo(a2.getDod())));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (E el: familyTreeList) {
            str.append(el + "\n");
        }
        String res = String.valueOf(str);
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(familyTreeList);
    }

}
