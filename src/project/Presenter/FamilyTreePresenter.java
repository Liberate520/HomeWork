package project.Presenter;
import project.Members.Human;

public interface FamilyTreePresenter {
    void loadFamilyTree(String filename);
    void saveFamilyTree(String filename);
    void addMember(Human member);
    void displayChildrenOf(String name);
    void sortByName();
    void sortByBirthDate();
}
