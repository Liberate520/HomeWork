package family_tree.family_tree;

import family_tree.comparators.ComparatorByDateOfBirthday;
import family_tree.comparators.ComparatorByName;
import family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree implements Serializable, Iterable<Human> {
    ArrayList<Human> family_tree;

    public FamilyTree(){
        family_tree = new ArrayList<Human>();
    }

    public ArrayList<Human> getFamily_tree(){
        return family_tree;
    }

    public void addHuman(Human human){
        family_tree.add(human);
    }

    public void removeHuman(Human human){
        family_tree.remove(human);
    }

    public Human findHuman(String first_name, String last_name, String patronymic){
        for (Human human : family_tree){
            if (human.getFirst_name().equals(first_name) && human.getLast_name().equals(last_name) && human.getPatronymic().equals(patronymic)){
                return  human;
            }
        }
        return null;
    }

    public ArrayList<Human> getDescendants(Human human) {
        ArrayList<Human> descendants = new ArrayList<>();
        for (Human child : human.getChildren()) {
            descendants.add(child);
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }

    public ArrayList<Human> getAncestors(Human human) {
        ArrayList<Human> ancestors = new ArrayList<>();
        if (human.getFather() != null){
            ancestors.add(human.getFather());
            ancestors.addAll(getAncestors(human.getFather()));
        }
        if (human.getMother() != null){
            ancestors.add(human.getMother());
            ancestors.addAll(getAncestors(human.getMother()));
        }
        return ancestors;
    }

    public void sortByDateOfBirthday(){
        family_tree.sort(new ComparatorByDateOfBirthday());
    }

    public void sortByName(){
        family_tree.sort(new ComparatorByName());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Human human : family_tree){
            if (first == true){
                sb.append(human.toString());
                first = !first;
            }
            else sb.append(", ").append(human.toString());
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return family_tree.iterator();
    }
}
