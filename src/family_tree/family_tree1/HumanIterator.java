package familyTree.src.family_tree.family_tree1;


import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
        private int index;
        private List<E> humanList;
        public HumanIterator(List<E> humanList){
            this.humanList = humanList;
        }

        @Override
        public boolean hasNext() {
            return index < humanList.size();
        }

        @Override
        public E next() {
            return humanList.get(index++);
        }
}
