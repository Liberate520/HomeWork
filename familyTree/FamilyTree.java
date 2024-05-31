package OOP.SemDZ.homeWork.familyTree;

import java.io.Serializable;
import java.util.List;

import OOP.SemDZ.homeWork.comparator.HumanComparatorByAge;
import OOP.SemDZ.homeWork.comparator.HumanComparatorByName;
import OOP.SemDZ.homeWork.human.Human;
import OOP.SemDZ.homeWork.human.HumanIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int idCount=0;
    private List<Human> humanTreeList;

    public FamilyTree() {
        humanTreeList = new ArrayList<>();
    }

    public void addHuman (Human human){
        idCount++;
        human.setId(idCount);
        humanTreeList.add(human);
    }

    public void wedding (Human groom, Human bride){
        groom.setSpouse(bride);
        bride.setSpouse(groom);
    }

    public void sortByName(){
        humanTreeList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanTreeList.sort(new HumanComparatorByAge());
    }

    @Override
    public String toString() {       
        return getInfo();
    }
    public String getInfo(){
        StringBuilder ft = new StringBuilder();
        ft.append("В дереве ");
        ft.append(humanTreeList.size());
        ft.append(" членов семьи: \n");
        for (Human human: humanTreeList){
            ft.append(human.getName());
            ft.append(", id ");
            ft.append(human.getId());
            ft.append(", gender ");
            ft.append(human.getGender());
            ft.append(", birthaday ");
            ft.append(human.getBirthDay());
            ft.append("\n");

        }
        return ft.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanTreeList);
    }

    

       
}
