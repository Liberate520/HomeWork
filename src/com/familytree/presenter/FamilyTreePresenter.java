package com.familytree.presenter;

import com.familytree.model.family_tree.FamilyTree;
import com.familytree.model.family_tree.FamilyTreeModel;
import com.familytree.model.human.Human;
import com.familytree.view.ConsoleUI;
import com.familytree.view.FamilyTreeView;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeModel model;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeModel model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }


    public void addHuman(Human human){
        model.addHuman(human);
        view.updateView();
        view.displayHumans();
    }

    public void sortByName() {
        model.sortByName();

    }

    public void getHumanListInfo() {
        List<Human> humans = FamilyTreeModel.getHumans();
        for (Human human : humans){
            System.out.println(human.getName());
        }
    }

    public void sortByBirthDate() {
        model.sortByBirthDate();
    }
}
