package familytree.presenter;

public interface IFamilyTreePresenter {
    void loadFamilyTree();
    void saveFamilyTree();
    void displayFamilyTree();
    void sortByName();
    void sortByAge();
    void createFamilyTree();
    void addHumanToTree(String name, String gender, String birthDate, String deathDate);
    void addParentToChild(String childName, String parentName);
    void addChildToParent(String parentName, String childName);
}
