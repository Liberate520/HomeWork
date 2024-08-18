package Model;

import java.util.Comparator;

public class HumanComporatorByName<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T h1, T h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
