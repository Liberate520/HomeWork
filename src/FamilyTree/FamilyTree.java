package FamilyTree;

import Human.Human;
import Human.HumanIterator;
import Human.HumanByAgeComparator;
import Human.HumanByNameComparator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humanId;
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public boolean addHuman(Human human){
        if(human == null){
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent : human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child : human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if(human == null){
            return null;
        }
        List<Human> result = new ArrayList<>();
        for (Human parent : human.getParents()){
            for(Human child : parent.getChildren()){
                if(!child.equals(human)){
                    result.add(child);
                }
            }
        }
        return result;
    }

    public Human getById(long id){
        for(Human human : humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public List<Human> getByName(String name){
        List<Human> result = new ArrayList<>();
        for(Human human : humanList){
            if(human.getName().equals(name)){
                result.add(human);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном древе: ");
        sb.append(humanList.size());
        sb.append(" человек: \n");
        for (Human human : humanList){
            sb.append(human);
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator(){
        return new HumanIterator(humanList);
    }

    public void sortByBirthDay(){
        humanList.sort(new HumanByAgeComparator());
    }

    public void sortByName(){
        humanList.sort(new HumanByNameComparator());
    }
}
