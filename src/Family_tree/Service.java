package Family_tree;

import java.io.Serializable;
import java.util.*;

import Family_tree.Humans.EndothermalInterface;

import Family_tree.Tree.Family_tree;

public class Service<T extends EndothermalInterface<T>> implements Serializable{

    private Family_tree<T> tree;
    private List<Family_tree<T>> trees;
    private long counter;
    private List<T> valuesList;
    private long counterOfT;
    private T currentItem;

    public Service() {
        trees = new ArrayList<>();
        valuesList = new ArrayList<>();
        this.counter = 0;
        this.counterOfT = 0;
    }

    public Family_tree<T> createTree(String family) {
        Family_tree<T> newTree = new Family_tree<>(family, counter);
        counter++;
        trees.add(newTree);
        return newTree;
    }

    public boolean add(Family_tree<T> family_tree) {
        try {
            family_tree.setid(counter);
            counter++;
            trees.add(family_tree);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public long nameValue(String string) {
        char[] chars = string.toCharArray();
        long vals = 0;
        for (char c : chars) {
            vals = (long) c + vals;
        }
        return vals;
    }

    public Family_tree<T> getTree(long index){
        if (this.trees.size() == 0){
            return null;
        }
        this.tree = this.trees.get((int) index);
        return this.tree;
    }

    public void addItem(T value){        
        value.setFamilyID(counterOfT);
        counterOfT++;
        valuesList.add(value);        
    }
    public T getHuman(long index){
        if (this.valuesList.size() == 0){
            return null;
        }
        this.currentItem = this.valuesList.get((int) index);
        return this.currentItem;
    }
    public String getItemsInfo(long index){
        Family_tree<T> currentTree = this.getTree(index);
        StringBuilder sb = new StringBuilder();
        sb.append("Список членов семьи " + currentTree.getFamily() + " \n");
        for (T value : currentTree) {
            sb.append(value + "\n");
        }
        return sb.toString();
    }
   

    

}
