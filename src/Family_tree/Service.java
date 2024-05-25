package Family_tree;

import java.util.*;
import Family_tree.Tree.Family_tree;

public class Service {

    private Family_tree tree;
    private List<Family_tree> trees;
    private long counter;

    public Service(){
        trees = new ArrayList<>();
        this.counter = 0;
    }

    public Family_tree createTree(String family){
        Family_tree newTree = new Family_tree(family, counter);
        counter ++;
        trees.add(newTree);
        return newTree;
    }


    public long nameValue(String string){
        char[] chars = string.toCharArray();
        long vals = 0;
        for (char c : chars) {
            vals = (long) c + vals;
        }
        return vals;
    }


}
