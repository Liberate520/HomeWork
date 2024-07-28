package family_tree.family_tree;

import family_tree.Interface.Animal;
import family_tree.comparators.ComparatorByDateOfBirthday;
import family_tree.comparators.ComparatorByName;
import family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<T extends Animal<T>> implements Serializable, Iterable<T> {
    ArrayList<T> family_tree;

    public FamilyTree(){
        family_tree = new ArrayList<T>();
    }

    public ArrayList<T> getFamily_tree(){
        return family_tree;
    }

    public void addHuman(T human){
        family_tree.add(human);
    }

    public void removeHuman(T human){
        family_tree.remove(human);
    }

    public T findHuman(String first_name, String last_name, String patronymic){
        for (T human : family_tree){
            if (human.getFirst_name().equals(first_name) && human.getLast_name().equals(last_name) && human.getPatronymic().equals(patronymic)){
                return  human;
            }
        }
        return null;
    }

    public ArrayList<T> getDescendants(T human) {
        ArrayList<T> descendants = new ArrayList<T>();
        for (T child : human.getChildren()) {
            descendants.add(child);
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }

    public ArrayList<T> getAncestors(T human) {
        ArrayList<T> ancestors = new ArrayList<T>();
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
        family_tree.sort(new ComparatorByDateOfBirthday<T>());
    }

    public void sortByName(){
        family_tree.sort(new ComparatorByName<T>());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (T human : family_tree){
            if (first == true){
                sb.append(human.toString());
                first = !first;
            }
            else sb.append(", ").append(human.toString());
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return family_tree.iterator();
    }
}
