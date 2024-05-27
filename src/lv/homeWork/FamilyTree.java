package lv.homeWork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E> {

    private final List<E> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(ArrayList<E> humanList) {
        this.humanList = humanList;
    }

    public void addHuman(E human){
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setGeneration();
        }
    }

    public List<Human> findByGeneration(int generation) {
        List<Human> result = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getGeneration() == generation) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean removeHuman(E human) {
        return humanList.remove(human);
    }


    public Human findHumanByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public void sortByBrith(){
        humanList.sort(new CompareByBirth<>());
    }

    public void sortByGen(){
        humanList.sort(new CompareByGen<>());
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder("Family tree contains: \n");
        for (E human : humanList) {
            sb.append(human.getInfo()).append("\n");
        }
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new IteratorForTree(humanList);
    }
}
