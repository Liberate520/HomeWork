package view.commands;

public interface CommandList {

    void save();

    void load();

    void add();

    void getFamilyTreeInfo();

    void setBirthDate();

    void setDeathDate();

    void setParents();

    void findByName();

    void sortByName();

    void sortByBirthDate();

    void sortByAge();

    void finish();
}
