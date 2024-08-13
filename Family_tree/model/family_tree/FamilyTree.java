package Family_tree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Family_tree.model.human.HumanComparatorByAge;
import Family_tree.model.human.HumanComparatorByName;

public class FamilyTree<T extends ItemFamilyTree<T>> implements Serializable, Iterable<T> {
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

    public int size(){
        return people.size();
    }

    public T getById(int id){
        for (T human: people){
            if (human.getId()== id){
                return human;
            }
        }
        return null;
    }

    public boolean addHuman(T human){
        if (human == null){
            return false;
        }
        if (!people.contains(human)){
            people.add((T) human);
            human.setId(humansId++);
            
            // addToFather(human);
            // addToMother(human);
            // addToChildren(human);
        
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
