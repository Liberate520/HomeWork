package family_tree.family_tree;

import family_tree.human.Human;
import family_tree.human.HumanComparatorByName;
import family_tree.human.HumanComparatorByBirthDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public void addMember(Human member) {
        this.humanList.add(member);
    }

    public List<Human> getMembers() {
        return humanList;
    }

    // Методы сортировки

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByDateOfBirth() {
        humanList.sort(new HumanComparatorByBirthDate<>());
    }

    // Реализация интерфейса Iterable<Human>
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new FamilyTreeIterator<Human>(humanList);
    }
}
