package family_tree.program_classes;

import family_tree.help_classes.HumanComparatorByBirth;
import family_tree.help_classes.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private ArrayList<Human> fTree;

    public FamilyTree() {
        this.fTree = new ArrayList<>();
    }

    public ArrayList<Human> getfTree() {
        return fTree;
    }

    public void addHuman(Human human){
            if (!fTree.equals(human)) {
                fTree.add(human);
            }
    }

    public ArrayList<Human> findInfoByDocument(String doc) {
        ArrayList<Human> result = new ArrayList<>();
        for (Human human : fTree) {
            if (human.getDocument().equals(doc)) {
                result.add(human);
            }
        }
        return result;
    }

    public ArrayList<Human> findInfoByName(String name) {
        ArrayList<Human> result = new ArrayList<>();
        for (Human human : fTree) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(fTree);
    }

    public boolean isEmpty() {
        return fTree.isEmpty();
    }

    public void sortByName(){
        Collections.sort(fTree);
    }

    public void sortBybirthDate(){
        Collections.sort(fTree, new HumanComparatorByBirth());
    }
}
