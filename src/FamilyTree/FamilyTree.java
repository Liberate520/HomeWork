package FamilyTree;

import Human.Human;
import Human.comparators.HumanComparatorByAge;
import Human.comparators.HumanComparatorByBirthdate;
import Human.comparators.HumanComparatorByChildrenNum;
import Human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree  implements Serializable, Iterable {
    private List<Human> family;
    private int id = -1;

    public FamilyTree(List<Human> family) {
        this.family = family;
    }

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addHuman(Human human) {
        if (!family.contains(human)) {
            family.add(human);
            id ++;
            human.setId(id);

            addChildren(human);
        }
    }

    public void addChildren(Human human) {
        if (human.getParents() != null) {
            for (Human parent : human.getParents()) {
                if (parent != null) {
                    parent.setChildren(human);
                }
            }
        }
    }

    public void setMarried (Human human, Human spouse) {
        if (human.getSpouse() == null && spouse.getSpouse() == null) {
            human.setSpouse(spouse);
            spouse.setSpouse(human);
        }
    }

    public void setDivorsed (Human human, Human spouse) {
        if (human.getSpouse() == spouse && spouse.getSpouse() == human) {
            human.setSpouse(null);
            spouse.setSpouse(null);
        }
    }

    public void showTree () {
        System.out.println("\nСемейное дерево:");
        for (Human human : family) {
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
    public Iterator iterator() {
        return new HumanIterator(family);
    }


}
