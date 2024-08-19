package FamilyTree.presenter;

public interface PresenterInterface {
    void saveFamilyTree();

    void loadFamilyTree();

    void sortByName();

    void sortByBirthDate();

    void sortByAge();

    boolean isFamilyTreeEmpty();
}
