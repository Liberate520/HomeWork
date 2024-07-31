package Family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Family_tree.human.Human;
import Family_tree.human.HumanComparatorByAge;
import Family_tree.human.HumanComparatorByName;

public class FamilyTree<T extends ItemFamilyTree> implements Serializable, Iterable<T> {
    private long humansId;  
    private List<T> people;

    public FamilyTree(){
        people = new ArrayList<>();
    }

    public T getByName(String nameHuman){
        for (T human: people){
            if (human.getName().equals(nameHuman)){
                return human;
            }
        }
        return null;
    }

    public boolean addHuman(Human human){
        if (human == null){
            return false;
        }
        if (!people.contains(human)){
            people.add((T) human);
            human.setId(humansId++);
            
            // addToParents(human);
            addToFather(human);
            addToMother(human);
            addToChildren(human);
        
            return true;
        }
        return false;
    }
    
        public void sortByName(){
            people.sort(new HumanComparatorByName<>());;
        }
    
        public void sortByAge(){
            people.sort(new HumanComparatorByAge<>());
        }
    
    // private void addToParents(Human human){
    //     for (Human parent : human.getParents()) {
    //         parent.addChild(human);
    //     }
    // }

    private void addToFather(Human human){
        if (human.getFather() != null){
            human.getFather().addChild(human);
        }
    }

    private void addToMother(Human human){
        if (human.getMother() != null){
            human.getMother().addChild(human);
        }
    }
    
    
    private void addToChildren(Human human){
        for (Human child : human.getChildren()) {
            child.addFather(human);
            child.addMother(human);
        }
    }


    // public boolean getMarried(Human human1, Human human2) {
    //     if (human1.getSpouse() == null && human2.getSpouse() == null) {
    //         human1.setSpouse(human2);
    //         human2.setSpouse(human1);
    //         human2.setChildren(human1.getChildren());
    //         human1.setChildren(human2.getChildren());
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    public boolean getDivorsed(T human1, T human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }


    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family members list:\n");
        for (T human: people){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

       @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(people);
    }
}
