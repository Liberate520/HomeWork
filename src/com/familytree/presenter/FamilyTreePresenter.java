
package com.familytree.presenter;

import com.familytree.model.animal.Dog;
import com.familytree.model.family_tree.FamilyTreeModel;
import com.familytree.model.family_tree.TreeNode;
import com.familytree.model.human.Human;
import com.familytree.view.View;

import java.util.List;

public class FamilyTreePresenter<T extends TreeNode> {
    private final FamilyTreeModel<T> model;
    private final View view;

    public FamilyTreePresenter(FamilyTreeModel<T> model, View view) {
        this.model = model;
        this.view = view;
    }

    public void addNode(T node) {
        model.addNode(node);
        view.updateView();
        view.displayNodes(model.getNodes().toArray(new TreeNode[0]));
    }

    public void addHuman(Human human) {
        addNode((T) human);
    }

    public void addDog(Dog dog) {
        addNode((T) dog);
    }

    public List<T> getNodes() {
        return model.getNodes();
    }

    public void sortByName() {
        model.sortByName();
        view.displayNodes(model.getNodes().toArray(new TreeNode[0]));
    }

    public void sortByBirthDate() {
        model.sortByBirthDate();
        view.displayNodes(model.getNodes().toArray(new TreeNode[0]));
    }

    public void getNodeListInfo() {
        List<T> nodes = model.getNodes();
        for (T node : nodes) {
            System.out.println(node.getName());
        }
    }
}
