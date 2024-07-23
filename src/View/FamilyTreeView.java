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

    // public void showFamilyTree(List<Human> familyMembers) {
    //     for (Human member : familyMembers) {
    //         System.out.println("Name: " + member.getName());
    //         showChildren(member, "  ");
    //     }
    // }

    // private void showChildren(Human parent, String indent) {
    //     for (Human child : parent.getChildren()) {
    //         System.out.println(indent + "Child: " + child.getName());
    //         showChildren(child, indent + "  ");
    //     }
    // }
}

