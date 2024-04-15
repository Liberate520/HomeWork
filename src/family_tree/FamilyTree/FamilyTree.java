package family_tree.FamilyTree;

import family_tree.Human.Human;
import family_tree.Human.HumanComparatorByBirthday;
import family_tree.Human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private final List<Human> list;

    public FamilyTree() {
        list = new ArrayList<>();
    }

    public void addHuman(Human human) {
        list.add(human);
    }

    public List<Human> getHumanChildren(Human human) {
        if(human.getChildren() != null){
            return human.getChildren();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Древо семьи: \n");
        for (Human human : list) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(list);
    }

    public void sortByName(){
        list.sort(new HumanComparatorByName());
    }

    public void sortByBirthday(){
        list.sort(new HumanComparatorByBirthday());
    }
}