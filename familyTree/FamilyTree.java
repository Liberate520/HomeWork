package homeWork.familyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import homeWork.human.Human;
import homeWork.human.humanComparator.HumanComparatorByDate;
import homeWork.human.humanComparator.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> list;
    
    public FamilyTree() {
        this.list = new ArrayList<>();
    }

    public void addHuman(Human name) {
        list.add(name);
    }

    public String printTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        for (Human human : list){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortbyName(){
        list.sort(new HumanComparatorByName());
    }

    public void sortbyDate(){
        list.sort(new HumanComparatorByDate());
    }

    @Override
    public Iterator<Human> iterator(){
        return new FamilyTreeIterator(list);
    }
}
