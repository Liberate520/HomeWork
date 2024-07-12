package family__tree.presenter;

import java.time.LocalDate;

public interface TreePresenter {

    void addHuman(String name, LocalDate birthDate, String gender);

    void addChild(String parentName, String childName);

    void removeHuman(String name);

    void findHuman(String name);

    void listHumans();

    void showChildren(String parentName);

    void showParents(String childName);

    void sortByName();

    void sortByAge();

    void saveTree();

    void loadTree();
}
