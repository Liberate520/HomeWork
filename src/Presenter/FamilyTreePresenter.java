package Presenter;

import java.util.List;

import Model.FamilyTree;
import Model.Human;
import Model.HumanComporatorByBirthDate;
import View.FamilyTreeView;

public class FamilyTreePresenter {
    private FamilyTree familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void displayFamilyTree() {
        view.displayFamilyTree(familyTree.getAllMembers());
    }

    public void childrenRequest() {
        String name = view.getNameForChildren();
        List<Human> children = familyTree.getChildrenOf(name);
        children.sort(new HumanComporatorByBirthDate());
        view.displayChildren(name, children);
    }

    public void parentsRequest() {
        String name = view.getNameForParents();
        List<Human> parents = familyTree.getParentsOf(name);
        parents.sort(new HumanComporatorByBirthDate());
        view.displayParents(name, parents);
    }
}
