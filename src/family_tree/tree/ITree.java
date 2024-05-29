package family_tree.tree;

public interface ITree<T>{
    boolean addToTree(T obj);
    void sortByAge();
    void sortByName();
    void sortByBirthDate();
    void sortByDeathDate();
}
