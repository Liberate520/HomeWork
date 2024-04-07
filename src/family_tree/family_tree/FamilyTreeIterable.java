package family_tree.family_tree.family_tree;

import family_tree.human.Human;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class FamilyTreeIterable<T extends Human> implements Iterable<Human> {
    private final List<T> humanList;

    public FamilyTreeIterable(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public Iterator<Human> iterator() {
        return new Iterator<>() {
            private final Iterator<T> iter = humanList.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Human next() {
                return iter.next();
            }
        };
    }

    public void sortByLastName() {
        humanList.sort(Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        Comparator<T> byBirthDate = Comparator.comparing(Human::getBirthDate);
        humanList.sort(Collections.reverseOrder(byBirthDate));
    }
}
