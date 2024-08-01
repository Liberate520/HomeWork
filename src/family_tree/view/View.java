package family_tree.view;

public interface View {
    void start();
    void printAnswer(String str);
    void getFamily();
    void removeHuman();
    void findHumanByID();
    void findHumanByName();
    void getAncestors();
    void getDescendants();
    void sortByBirthday();
    void sortByName();
    void Save();
    void load();
    void exit();
    void addHuman();
}
