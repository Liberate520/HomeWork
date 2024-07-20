package View;

import java.util.List;
import Human.Human;
import Presenter.FamilyTreePresenter;

public interface FamilyTreeView {
    void setPresenter(FamilyTreePresenter presenter);
    void showFamilyTree(List<Human> family);
    void displayMessage(String message);
    void showError(String message);
    void showMenu();
}

