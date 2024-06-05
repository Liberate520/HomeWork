package model.family_tree.tree;

public interface ITree<T>{
    boolean addToTree(T obj);
    void sortByAge();
    void sortByName();
    void sortByBirthDate();
    void sortByDeathDate();
    boolean setMother(T objForSet, T mother);
    boolean setFather(T objForSet, T father);
    int getNumInFamily();
    T getFamilyMenber(int index);
}
