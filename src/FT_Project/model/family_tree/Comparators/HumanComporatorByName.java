package FT_Project.model.family_tree.Comparators;

import java.util.Comparator;

import FT_Project.model.Human.Human;
import FT_Project.model.family_tree.Element;


public class HumanComporatorByName<E extends Element> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
