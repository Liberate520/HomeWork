
package com.familytree.presenter;

import com.familytree.model.family_tree.FamilyTreeModel;
import com.familytree.model.human.Human;
import com.familytree.view.View;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private final FamilyTreeModel model;
    private final View view;

    public FamilyTreePresenter(FamilyTreeModel model, View view) {
        this.model = model;
        this.view = view;
    }

    public void addNode(String name, LocalDate birthDate) {
        Human human = new Human(model.getNodes().size() + 1, name, birthDate);
        model.addNode(human);
        updateView();
    }

    public void getNodesListInfo() {
        List<Human> nodes = model.getNodes();
        view.displayNodes(nodes.toArray(new Human[0]));
    }

    public void sortByName() {
        model.sortByName();
        updateView();
    }

    public void sortByBirthDate() {
        model.sortByBirthDate();
        updateView();
    }

    private void updateView() {
        view.displayNodes(model.getNodes().toArray(new Human[0]));
    }
}
