package Model.FamilyTree;

import Model.Human.Gender;
import Model.Human.comparators.*;

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
        }
    }

    public void deleteHuman(int id) {
        E toRemove = null;
        for (E e : family) {
            if (e.getId() == id) toRemove = e;
        }
        family.remove(toRemove);
    }

    public void addChild(E human, E child) {
        human.setChildren(child);
        if (human.getGender() == Gender.Male){
            child.setFather(human);
        }
        if (human.getGender() == Gender.Female){
            child.setMother(human);
        }
    }

    public void addParent(E human, E parent) {
        if (parent.getGender() == Gender.Male){
            human.setFather(parent);
        }
        if (parent.getGender() == Gender.Female){
            human.setMother(parent);
        }
        parent.setChildren(human);
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

    public int showFamilyTreeSize(){
        return family.size();
    }

    public void SortById(){
        family.sort(new HumanComparatorByID<>());
    }

    public void SortByName(){
        family.sort(new HumanComparatorByName<>());
    }

    public void SortByAge(){
        family.sort(new HumanComparatorByAge<>());
    }

    public void SortByChildrenNum(){
        family.sort(new HumanComparatorByChildrenNum<>());
    }

    public void SortByBirthdate(){
        family.sort(new HumanComparatorByBirthdate<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(family);
    }
}
