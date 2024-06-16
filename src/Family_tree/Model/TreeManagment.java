package Family_tree.Model;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Tree.Family_tree;

public interface TreeManagment<T extends Endothermal> {
    boolean newTree(String family);
    boolean addTree(Family_tree<T> tree);
    boolean setActiveTree(int ID);
    boolean setActiveTree(long innerID);
    boolean setActiveTree(Family_tree<T> tree);
    boolean deleteTree(int ID);
    boolean deleteTree(long innerID);
    boolean deleteTree(Family_tree<T> tree);
    boolean loadTree(String path);
    boolean saveTree(String path);
    int getActiveTreeIndex();
    long getActiveTreeInnerID();
    boolean haveActiveTree();
    boolean join(Family_tree<T> tree1, Family_tree<T> tree2);
  /*boolean divide(); Разделение древа по веткам. Пока идей как это сделать - нет */
    String getInfo(); //для ActiveTree
}
