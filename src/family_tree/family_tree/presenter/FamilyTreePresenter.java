package family_tree.family_tree.presenter;

import family_tree.family_tree.model.FamilyTreeModel;
import family_tree.family_tree.view.FamilyTreeView;
import family_tree.human.Human;

public class FamilyTreePresenter {
    private FamilyTreeModel model;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeModel model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void startApplication() {
        view.runApplicationLoop();
    }

    public void displayFamilyMembers() {
        view.displayFamilyMembers(model.getFamilyMembers());
    }

    public void addNewFamilyMember(Human newMember) {
        model.addFamilyMember(newMember);
        view.displayMessage("Новый член семьи успешно добавлен.");
    }

    public void sortByName() {
        model.sortFamilyMembersByName();
        view.displaySortedFamilyMembers(model.getFamilyMembers());
    }

    public void sortByBirthDate() {
        model.sortFamilyMembersByBirthDate();
        view.displaySortedFamilyMembers(model.getFamilyMembers());
    }
}