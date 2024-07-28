package View;

import java.util.List;

import Human.Human;
import Presenter.FamilyTreePresenter;


public interface FamilyTreeView {

    void displayFamilyTree(List<Human> familyMembers);
    void displayMessage(String message);
    void showError(String errorMessage);
    void showFamilyTree(List<Human> familyTree);
    void setPresenter(FamilyTreePresenter presenter);
    void showMenu();


}
