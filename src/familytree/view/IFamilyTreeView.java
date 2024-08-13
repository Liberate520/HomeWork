package familytree.view;

public interface IFamilyTreeView {
    void displayFamilyTree(String familyTree);
    void displayMessage(String message);
    void displaySortedTreeByAge(String sortedTree);
    void displaySortedTreeByName(String sortedTree);
    String getFilePath();
}
