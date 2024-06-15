
package com.familytree.view;

import com.familytree.model.family_tree.TreeNode;
import com.familytree.presenter.FamilyTreePresenter;

public class ConsoleView implements View {
    private FamilyTreePresenter<TreeNode> familyTreePresenter;

    public ConsoleView(FamilyTreePresenter<TreeNode> familyTreePresenter) {
        this.familyTreePresenter = familyTreePresenter;
    }

    @Override
    public void updateView() {
        System.out.println("View updated.");
    }

    @Override
    public void displayNodes(TreeNode[] nodes) {
        for (TreeNode node : nodes) {
            System.out.println("ID: " + node.getId() + ", Name: " + node.getName());
        }
    }

    @Override
    public FamilyTreePresenter<TreeNode> getFamilyTreePresenter() {
        return familyTreePresenter;
    }
}
