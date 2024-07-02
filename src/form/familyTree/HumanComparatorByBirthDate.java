package form.familyTree;

import form.forming.Create;

import java.util.Comparator;

public class HumanComparatorByBirthDate<T extends Create> implements Comparator<T> {
    @Override
    public int compare(T h1, T h2){return h1.getBirthDate().compareTo(h2.getBirthDate());}
}