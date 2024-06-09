package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human>, Serializable {
    private List<Human> familyTreeList = new ArrayList<>();
    private List<Long> emptyIds = new ArrayList<>();


    private void letHumanId(Human human) {
        human.setId(human.getCurrentId());
        human.setCurrentId();
    }

    public void addHumansInFamTree(Human... human) {
        for (Human fam: human) {
            familyTreeList.add(fam);
            if (emptyIds.isEmpty()) {
                letHumanId(fam);
            }
            else {
                fam.setId(emptyIds.get(0));
            }
        }
    }

    public void removeHumansFromFamTree(Human... human) {
        for (Human fam: human) {
            familyTreeList.remove(fam);
            emptyIds.add(fam.getId());
        }
    }


    public void removeHumanFromFamTree(Human... human){
        for (Human fam: human) {
            familyTreeList.remove(fam);
        }
    }

    public Human findHuman(String firstName){
        for (Human el : familyTreeList) {
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
        for (Human el: familyTreeList) {
            str.append(el + "\n");
        }
        String res = String.valueOf(str);
        return res;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTreeList);
    }

}
