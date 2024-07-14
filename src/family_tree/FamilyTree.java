package family_tree;

import human.Human;
import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public Human getReadName(String nameHuman){
        for (Human human: humans){
            if (human.getName().equals(nameHuman)){
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    public Human getHuman(int id){
        for (Human human: humans){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public void sortByName(){
        humans.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humans.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }

}
