package model.family_tree.tree;

import model.family_tree.instances.comparators.ComparatorByAge;
import model.family_tree.instances.comparators.ComparatorByBurthDate;
import model.family_tree.instances.comparators.ComparatorByDeathDate;
import model.family_tree.instances.comparators.ComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeItem<T>> implements Serializable, Iterable<T>, ITree<T>, ITreeSort<T> {
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
        objects.sort(new ComparatorByAge<>());
    }

    @Override
    public void sortByName() {
        objects.sort(new ComparatorByName<>());
    }

    @Override
    public void sortByBirthDate() {
        objects.sort(new ComparatorByBurthDate<>());
    }

    @Override
    public void sortByDeathDate() {
        objects.sort(new ComparatorByDeathDate<>());
    }

    public boolean setMother(T objForSet, T mother) {
        if(objects.contains(objForSet) && objects.contains(mother)){
            objForSet.setMother(mother);
            return true;
        }else {
            return false;
        }
    }

    public boolean setFather(T objForSet, T father){
        if(objects.contains(objForSet) && objects.contains(father)){
            objForSet.setFather(father);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int getNumInFamily() {
        return objects.size();
    }

    @Override
    public T getFamilyMember(int index) {
        if(index < objects.size()){
            return objects.get(index);
        }else {
            return null;
        }
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
        int i = 1;
        for (T obj : objects) {
            stringBuilder.append(i + ": ");
            stringBuilder.append("\t" + obj);
            stringBuilder.append("\n");
            i++;
        }

        return stringBuilder.toString();
    }
}
