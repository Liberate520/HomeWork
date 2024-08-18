package Presenter;

import java.util.List;

import Model.FamilyTree;
import Model.Human;
import Model.HumanComporatorByBirthDate;
import View.FamilyTreeView;

public class FamilyTreePresenter<T extends Human> {
    private FamilyTree<T> familyTree;
    private FamilyTreeView<T> view;

    public FamilyTreePresenter(FamilyTree<T> familyTree, FamilyTreeView<T> view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void displayFamilyTree() {
        List<T> members = familyTree.getAllMembers();
        if (members.isEmpty()) {
            view.displayMessage("Семейное древо пусто.");
        } else {
            view.displayFamilyTree(members);
        }
    }

    public void childrenRequest() {
        String name = view.getNameForChildren();
        List<T> children = familyTree.getChildrenOf(name);
        children.sort(new HumanComporatorByBirthDate<Human>());
        view.displayChildren(name, children);
    }

    public void parentsRequest() {
        String name = view.getNameForParents();
        List<T> parents = familyTree.getParentsOf(name);
        parents.sort(new HumanComporatorByBirthDate<Human>());
        view.displayParents(name, parents);
    }
}
