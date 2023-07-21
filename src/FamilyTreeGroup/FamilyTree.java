package Tree.homeWork.src.FamilyTreeGroup;
import Tree.homeWork.src.HumanGroup.Human;
import Tree.homeWork.src.HumanGroup.Comparators.HumanComparatorByAge;
import Tree.homeWork.src.HumanGroup.Comparators.HumanComparatorByName;

import java.util.*;

public class FamilyTree implements Iterable<Human> {
    private List<Human> humanList;
    public FamilyTree(){
        humanList = new ArrayList<>();
    }
//    public void addHuman(Human human){
//        humanList.add(human);
//    }
    public boolean addHuman(Human human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
        if (human.getFather() != null){
            human.getFather().addChild(human);
        }
        if (human.getMother() != null){
            human.getMother().addChild(human);
        }
        return true;
        }
        return false;
    }
    public Human getHumanByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
    public List<Human> getHumanList() {
        return humanList;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
    public void sortByName(){
        Collections.sort(humanList, new HumanComparatorByName());
    }

    public void sortByAge() {
        Collections.sort(humanList, new HumanComparatorByAge());
    }
}
