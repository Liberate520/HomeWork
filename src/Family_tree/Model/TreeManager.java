package Family_tree.Model;

import java.util.*;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Tree.Family_tree;

public class TreeManager<T extends Endothermal> implements TreeManagment<T> {

    private Family_tree<T> activeTree;
    private List<Family_tree<T>> list;
    private Service<T> service;
    private ElementManager<T> elementManager;

    public TreeManager (Service<T> service, ElementManager<T> element){
        this.service = service;
        this.elementManager = element;
        this.activeTree = null; //Ну не верю я в надежность автозаполнения.....
        this.list = new ArrayList<>();
    }

    public boolean isEmpty(){
        return this.list.isEmpty();
    }


    @Override
    public boolean newTree(String family) {
        try{
            Family_tree<T> ntree = new Family_tree<T>(family);
            list.add(ntree);
            this.activeTree = ntree;
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean addTree(Family_tree<T> tree) {
        if (list.contains(tree)){
            return false;
        }
        list.add(tree);
        this.activeTree = tree;
        return true;
    }

    @Override
    public boolean setActiveTree(int ID) {
        Family_tree<T> searched;
        try{
            searched = this.list.get(ID)  ;
        } catch(Exception e){
            return false;
        }
        
        if (searched != null){
            this.activeTree = searched;
            return true;
        }
        return false;
    }
    private Family_tree<T> byInnerIdSearch(long ID){
        for (Family_tree<T> item : this.list) {
            if (Long.compare(item.getInnerID(), ID) == 0){
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean setActiveTree(long innerID) {
        Family_tree<T> searched = byInnerIdSearch(innerID);
        if (searched != null){
            this.activeTree = searched;
            return true;
        }
        return false;
    }

    @Override
    public boolean setActiveTree(Family_tree<T> tree) {
        try{
            if (!list.contains(tree)){
                this.list.add(tree);
            }
            this.activeTree = tree;
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteTree(int ID) {        
        try{
            this.list.remove(ID)  ;
            this.activeTree = null;
            return true;
        } catch(Exception e){
            return false;
        }       
    }

    @Override
    public boolean deleteTree(long innerID) {
        Family_tree<T> searched = byInnerIdSearch(innerID);
        if (searched != null){
            this.activeTree =null;
            this.list.remove(searched);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTree(Family_tree<T> tree) {
        try{
            this.list.remove(tree);
            this.activeTree = null;
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean loadTree(String path) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadTree'");
    }

    @Override
    public boolean saveTree(String path) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveTree'");
    }    
    public Family_tree<T> getActiveTree() {
        return this.activeTree;
    }

    @Override
    public String getInfo() { // Для ActiveTree
        return this.activeTree.getInfo();
    }


    @Override
    public boolean join(Family_tree<T> tree1, Family_tree<T> tree2) {
        try{
            Set<T> set = new HashSet<>(tree1.getMemberList());
            set.addAll(tree2.getMemberList());
            tree1.setMemberList(new ArrayList<>(set));
            deleteTree(tree2);
            return true;
        }  catch(Exception e) {
            return false;
        } 
    }

    @Override
    public int getActiveTreeIndex() {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).equals(this.activeTree)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public long getActiveTreeInnerID() {
        if (this.haveActiveTree()){
            return this.activeTree.getInnerID();
        }
        return -1;
    }

    @Override
    public boolean haveActiveTree() {
        if (this.activeTree == null){
            return false;
        }
        return true;
    }
}
