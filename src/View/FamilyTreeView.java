package View;

import java.util.List;

import Human.Human;
import Presenter.FamilyTreePresenter;

public interface FamilyTreeView {
    void setPresenter(FamilyTreePresenter presenter);
    void showMenu();
    void showFamilyTree(List<Human> familyMembers);
}
