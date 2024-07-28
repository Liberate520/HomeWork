package familytree;

import java.util.ArrayList;

public interface Creature <T>{
    String getName();
    ArrayList<T> getParents();
    ArrayList<T> getAmountOfChildren();
}
