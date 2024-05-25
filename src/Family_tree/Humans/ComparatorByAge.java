package Family_tree.Humans;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {        
        return o1.getAge() - o2.getAge();
    }

}
