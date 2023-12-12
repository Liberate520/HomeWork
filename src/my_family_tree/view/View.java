package my_family_tree.view;

import my_family_tree.model.writer.FileHandler;

public interface View {
    void start();
    void answer(String answer);
    void addHumanToTheFamily();
    void addParents();
    void getTreeInfo();
    void sortByAge();
    void sortByName();
    void sortByYear();
    void finish();
    void wedding();

    void load();

    void save();

    void setDeathDate();

}
