
package com.familytree.view;

import com.familytree.model.family_tree.TreeNode;
import com.familytree.presenter.FamilyTreePresenter;

public interface View {
    void updateView();
    void displayNodes(TreeNode[] nodes);
    FamilyTreePresenter<TreeNode> getFamilyTreePresenter();
}
