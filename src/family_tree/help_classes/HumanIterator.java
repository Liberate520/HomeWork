package family_tree.help_classes;

import family_tree.program_classes.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator implements Iterator<Human> {
    private int current_index;
    private ArrayList<Human> fTree;

    public HumanIterator(ArrayList<Human> fTree) {
        this.fTree = fTree;
    }

    @Override
    public boolean hasNext() {
        return fTree.size() > current_index;
    }

    @Override
    public Human next() {
        return fTree.get(current_index++);
    }
}