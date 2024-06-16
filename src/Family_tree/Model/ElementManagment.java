package Family_tree.Model;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Tree.Family_tree;

public interface ElementManagment<T extends Endothermal> {
    boolean newSubject(String name, String gender, String bd);
    boolean addToTree(T subject); //для ActiveTree
    boolean addToTree(T subject, Family_tree<T> tree);
    boolean setActiveSubject(int id);
    boolean setActiveSubject(long innerID);
    boolean setActiveSubject(T subject);
    String searchSubject(String pattern); //для ActiveTree
    String searchSubject(String pattern, Family_tree<T> tree);
    String searchSubject(String pattern, long treeInnerID);
    String searchSubject(String pattern, int treeIndex);
    boolean setChild(T subject, T father, T mother); //для ActiveTree
    boolean setChild(int subject, int father, int mother, Family_tree<T> tree);
    boolean setChild(long subject, long father, long mother);
    int getActiveSubjectIndex();
    long getActiveSubjectInnerID();
    String getInfo(); //для ActiveSubject
    
}
