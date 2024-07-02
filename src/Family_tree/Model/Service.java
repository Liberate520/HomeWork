package Family_tree.Model;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.Model.Tree.TreesCollection;

public abstract class Service<T extends Endothermal> implements ElementManagment<T>, TreeManagment<T> {

    private TreesCollection<T> collection;

    public boolean Transfer(Family_tree<T> parenTree, Family_tree<T> aimTree, T item){
        try{
            parenTree.remove(item);
            aimTree.add(item);
            collection.setActiveTree(aimTree);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


  


}
