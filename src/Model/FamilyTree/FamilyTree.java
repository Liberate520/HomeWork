package Model.FamilyTree;

import Model.Human.HumanIterator;
import Model.Human.HumanByAgeComparator;
import Model.Human.HumanByNameComparator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends ItemFamilyTree<T>> implements Serializable, Iterable<T> {
    private long humanId;
    private List<T> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public boolean addHuman(T human){
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

    public void addToParents(T human){
        for (T parent : human.getParents()){
            parent.addChild(human);
        }
    }

    public void addToChildren(T human){
        for (T child : human.getChildren()){
            child.addParent(human);
        }
    }

    public List<T> getSiblings(int id){
        T human = getById(id);
        if(human == null){
            return null;
        }
        List<T> result = new ArrayList<>();
        for (T parent : human.getParents()){
            for(T child : parent.getChildren()){
                if(!child.equals(human)){
                    result.add(child);
                }
            }
        }
        return result;
    }

    public T getById(long id){
        for(T human : humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public List<T> getByName(String name){
        List<T> result = new ArrayList<>();
        for(T human : humanList){
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
        for (T human : humanList){
            sb.append(human);
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator(){
        return new HumanIterator<>(humanList);
    }

    public void sortByBirthDay(){
        humanList.sort(new HumanByAgeComparator<T>());
    }

    public void sortByName(){
        humanList.sort(new HumanByNameComparator<T>());
    }
}
