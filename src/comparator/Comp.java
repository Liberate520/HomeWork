package src.comparator;

import java.util.Comparator;
import src.Human;


public class Comp implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        // TODO Auto-generated method stub
        return o1.age.compareTo(o2.age);
    }
}

