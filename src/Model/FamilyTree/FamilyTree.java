package Model.FamilyTree;

import Model.Human.comparators.HumanComparatorByAge;
import Model.Human.comparators.HumanComparatorByBirthdate;
import Model.Human.comparators.HumanComparatorByChildrenNum;
import Model.Human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>>  implements Serializable, Iterable<E> {
    private List<E> family;
    private int id = -1;

    public FamilyTree(List<E> family) {
        this.family = family;
    }

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addHuman(E human) {
        if (!family.contains(human)) {
            family.add(human);
            id ++;
            human.setId(id);

            //addChildren(human);
        }
    }

    public void deleteHuman(int id) {
        E toRemove = null;
        for (E e : family) {
            if (e.getId() == id) toRemove = e;
        }
        family.remove(toRemove);
    }

    public void addChildren(E human) {
//        List<E> parents = human.getParents();
//        if (parents != null) {
//            for (int i = 0; i < parents.size(); i++) {
//                E parent = parents.get(i);
//                if (parents.get(i) != null) {
//                    parent.setChildren(human);
//                }
//            }
//        }
        if (human.getParents() != null) {
            for (E parent : human.getParents()) {
                if (parent != null) {
                    parent.setChildren(human);
                }
            }
        }
    }

    public void setMarried (E human, E spouse) {
        if (human.getSpouse() == null && spouse.getSpouse() == null) {
            human.setSpouse(spouse);
            spouse.setSpouse(human);
        }
    }

    public void setDivorsed (E human, E spouse) {
        if (human.getSpouse() == spouse && spouse.getSpouse() == human) {
            human.setSpouse(null);
            spouse.setSpouse(null);
        }
    }

    public void showTree () {
        System.out.println("\nСемейное дерево:");
        for (E human : family) {
            System.out.println(human);
        }
        System.out.println("Всего " + family.size() + " элементов.\n");
    }

    public int showFamilyTreeSize(){
        return family.size();
    }

    public void SortByName(){
        family.sort(new HumanComparatorByName());
    }

    public void SortByAge(){
        family.sort(new HumanComparatorByAge());
    }

    public void SortByChildrenNum(){
        family.sort(new HumanComparatorByChildrenNum());
    }

    public void SortByBirthdate(){
        family.sort(new HumanComparatorByBirthdate());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(family);
    }



}
