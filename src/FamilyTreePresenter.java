public interface FamilyTreePresenter {
    void onSearchById(String id);
    void onSearchByName(String name);
    void onSearchBySurname(String surname);
    void onShowChildren(String id);
    void onSaveTree(String filename);
    void onLoadTree(String filename);
    void onSortByAge();
    void onSortByGender();
    void onExit();
    void showMenu();
}