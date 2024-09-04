package Presenter;

import java.util.List;

import Model.FamilyTree;
import Model.FamilyMember;
import Model.FamilyMemberComparatorByBirthDate;
import View.FamilyTreeView;

public class FamilyTreePresenter<T extends FamilyMember> {
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
        if (children != null) {
            children.sort(new FamilyMemberComparatorByBirthDate<>());
            view.displayChildren(name, children);
        } else {
            view.displayMessage("Дети не найдены.");
        }
    }

    public void parentsRequest() {
        String name = view.getNameForParents();
        List<T> parents = familyTree.getParentsOf(name);
        if (parents != null) {
            parents.sort(new FamilyMemberComparatorByBirthDate<>());
            view.displayParents(name, parents);
        } else {
            view.displayMessage("Родители не найдены.");
        }
    }
}