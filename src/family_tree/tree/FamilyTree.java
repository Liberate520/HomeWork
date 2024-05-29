package family_tree.tree;

import family_tree.objects.comparators.ComparatorByAge;
import family_tree.objects.comparators.ComparatorByBurthDate;
import family_tree.objects.comparators.ComparatorByDeathDate;
import family_tree.objects.comparators.ComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeItem<T>> implements Serializable, Iterable<T>, ITree<T> {
    private List<T> objects;

    public FamilyTree() {
        this.objects = new ArrayList<>();
    }

    @Override
    public boolean addToTree(T obj) {
        if(obj == null){
            return false;
        }
        if(!objects.contains(obj)){
            objects.add(obj);
            return true;
        }
        return false;
    }

    @Override
    public void sortByAge() {
        objects.sort(new ComparatorByAge());
    }

    @Override
    public void sortByName() {
        objects.sort(new ComparatorByName());
    }

    @Override
    public void sortByBirthDate() {
        objects.sort(new ComparatorByBurthDate());
    }

    @Override
    public void sortByDeathDate() {
        objects.sort(new ComparatorByDeathDate());
    }

    @Override
    public Iterator<T> iterator() {
        return objects.iterator();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Фамильное древо:\n");

        stringBuilder.append("-----------------\n");
        for (T obj : objects) {
            stringBuilder.append("\t" + obj);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
