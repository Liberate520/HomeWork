package model.family_tree.tree;

public interface ITree<T>{
    boolean addToTree(T obj);
    boolean setMother(T objForSet, T mother);
    boolean setFather(T objForSet, T father);
    int getNumInFamily();
    T getFamilyMember(int index);
}
