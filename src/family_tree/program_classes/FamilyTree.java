package family_tree.program_classes;

import family_tree.help_classes.ComparatorByBirth;
import family_tree.help_classes.FamilyTreeItem;
import family_tree.help_classes.ItemIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private static final long serialVersionUID = 6529685098267757690L;
    private ArrayList<E> fTree;

    public FamilyTree() {
        this.fTree = new ArrayList<>();
    }

    public ArrayList<E> getfTree() {
        return fTree;
    }

    public void add(E element){
            if (!fTree.equals(element)) {
                fTree.add(element);
            }
    }

    public E findInfoByDocument(String doc) {
        E result = null;
        for (E element : fTree) {
            if (element.getDocument().equals(doc)) {
                result = element;
            }
        }
        return result;
    }

    public ArrayList<E> findInfoByName(String name) {
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

    public void sortBybirthDate(){
        Collections.sort(fTree, new ComparatorByBirth<>());
    }
}
