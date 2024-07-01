package form.familyTree;

import form.forming.Create;

import java.util.Comparator;

public class HumanComparatorByGender<T extends Create<T>> implements Comparator<T> {
    @Override
    public int compare(T h1, T h2){return h1.getGender().compareTo(h2.getGender());}
}