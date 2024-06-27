package Family_tree.Model.Tree;

import java.util.*;

import Family_tree.Model.Humans.Endothermal;

public class TreesCollection<T extends Endothermal> {

    private List<Family_tree<T>> list;
    private Family_tree<T> activeTree;

    public TreesCollection(){
        list = new ArrayList<>();
    }

    public boolean newTree(String family){
        try{
            Family_tree<T> tree = new Family_tree<T>(family);
            this.activeTree = tree;
            list.add(tree);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }

    public int size(){
        return list.size();
    }

    public boolean setActiveTree(int index){
        try {
            this.activeTree = this.list.get(index);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private Family_tree<T> treeByInnerID(long ID){
        for (Family_tree<T> tree : this.list) {
            if (tree.getInnerID() == ID) {
                return tree;
            }
        }
        return null;
    }

    public boolean setActiveTree(long ID){
        try {
            Family_tree<T> tree = treeByInnerID(ID);
            this.activeTree = tree; 
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Family_tree<T> getActiveTree(){
        return this.activeTree;
    }

    public int getActiveTreeIndex(){
        if (this.activeTree == null){
            return -1;
        }
        try{
            for (int i = 0; i < this.list.size(); i++){
                if (this.activeTree.equals(this.list.get(i))){
                    return i;
                }
            }
            return -1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public long getActiveTreeID(){
        try{
            return this.activeTree.getInnerID();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public Family_tree<T> selectTree(int index){
        return this.list.get(index);
    }

    public Family_tree<T> selectTree(long ID){
        return treeByInnerID(ID);
    }

    public boolean setActiveTree(Family_tree<T> item){
        try{
            if (!this.list.contains(item)){
                this.list.add(item);
            }
            this.activeTree = item;
            return true;
        } catch (Exception e) {
            return false;
        }        
    }

    
}
