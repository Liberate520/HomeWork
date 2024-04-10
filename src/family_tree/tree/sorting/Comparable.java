package family_tree.tree.sorting;

import family_tree.person.Human;

import java.util.ArrayList;

public interface Comparable<T extends Human> {
    ArrayList<T> sorting();
}
