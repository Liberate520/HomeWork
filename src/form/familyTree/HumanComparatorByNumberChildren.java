package form.familyTree;

import form.forming.Create;

import java.util.Comparator;

public class HumanComparatorByNumberChildren <T extends Create<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}