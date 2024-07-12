package family_tree;

import human.Human;

import java.util.Iterator;
import java.util.List;
//оставила на всякий чтоб показать как работала по семинару
public class Iterrator implements Iterator<Human>{
    private List<Human> humans;

    public Iterrator(List<Human> humans) {
        this.humans = humans;
    }

    private  int currentId;
        @Override
        public boolean hasNext() {
            return humans.size()< currentId;
        }

        @Override
        public Human next() {
            return humans.get(currentId++);
        }
    }

