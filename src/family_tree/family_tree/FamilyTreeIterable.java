package family_tree.family_tree;

import family_tree.human.Human;

import java.util.*;

public class FamilyTreeIterable implements Iterable<Human> {
    private final List<Human> humanList;

    public FamilyTreeIterable(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    public void sortByLastName() {
        humanList.sort(Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        Comparator<Human> byBirthDate = Comparator.comparing(Human::getBirthDate);
        humanList.sort(Collections.reverseOrder(byBirthDate));
    }
}

