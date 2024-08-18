package family_tree.model.program_classes;

import family_tree.model.help_classes.ComparatorByBirth;
import family_tree.model.help_classes.ItemIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private ArrayList<E> fTree;

    public FamilyTree() {
        this.fTree = new ArrayList<>();
    }

    public ArrayList<E> getfTree() {
        return fTree;
    }

    public boolean add(E element){
            if (!fTree.contains(element)) {
                fTree.add(element);
                return true;
            }
            return false;
    }

    public E findByDocument(String doc) {
        E result = null;
        for (E element : fTree) {
            if (element.getDocument().equals(doc)) {
                result = element;
            }
        }
        return result;
    }

    public ArrayList<E> findByName(String name) {
        ArrayList<E> result = new ArrayList<>();
        for (E element : fTree) {
            if (element.getName().equals(name)) {
                result.add(element);
            }
        }
        return result;
    }


    @Override
    public Iterator<E> iterator() {
        return new ItemIterator<>(fTree);
    }

    public boolean isEmpty() {
        return fTree.isEmpty();
    }

    public void sortByName(){
        Collections.sort(fTree);
    }

    public void sortByBirthDate(){
        Collections.sort(fTree, new ComparatorByBirth<>());
    }
}
