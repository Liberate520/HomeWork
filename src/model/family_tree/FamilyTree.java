package model.family_tree;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.family_tree.Comparator.HumanComparatorByBirthDate;
import model.family_tree.Comparator.HumanComparatorByName;

public class FamilyTree<E extends TreeNode<E>>  implements Serializable, Iterable<E> {
    private List<E> humans;
    
    public FamilyTree(){this(new ArrayList<>()); }
    public FamilyTree(List<E> humans){this.humans = humans;}

    public void addHuman(E human){
        humans.add(human);
        if(human.getMother() != null){
            human.getMother().addChild(human);
        }
        if(human.getFather() != null){
            human.getFather().addChild(human);
        }
    }


    public String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Древо состоит из ");
        stringBuilder.append(humans.size());
        stringBuilder.append(" человек:\n");
        for (E human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){ humans.sort(new HumanComparatorByName<>());}
    public void sortByBirthDate(){ humans.sort(new HumanComparatorByBirthDate<>());}

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humans);
    }

}
