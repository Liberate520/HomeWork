package family_tree.interfaces;

import family_tree.person.Human;

import java.util.ArrayList;

public interface Comparable {
    ArrayList<String> sortByAge();
    ArrayList<String> sortByName();
}
