package OOP.SemDZ.homeWork.model.familyTree;

import java.io.Serializable;
import java.util.List;

import OOP.SemDZ.homeWork.model.comparator.HumanComparatorByAge;
import OOP.SemDZ.homeWork.model.comparator.HumanComparatorByName;
import OOP.SemDZ.homeWork.model.human.Creature;
import OOP.SemDZ.homeWork.model.human.HumanIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<T extends Creature> implements Serializable, Iterable<T> {
    private int idCount=0;
    private List<T> humanTreeList;

    public FamilyTree() {
        humanTreeList = new ArrayList<>();
    }

    public void addHuman (T human){
        idCount++;
        human.setId(idCount);
        humanTreeList.add(human);
    }

    public void wedding (T groom, T bride){
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
        for (T human: humanTreeList){
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
    public Iterator<T> iterator() {
        return new HumanIterator(humanTreeList);
    }

    

       
}
