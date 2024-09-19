package ru.gb.family_tree;

import ru.gb.family_tree.model.FT.FamilyTreeItem;

import ru.gb.family_tree.view.View;
import ru.gb.family_tree.model.app.AppFactory;

public class Main {
    public static <T extends FamilyTreeItem<T>> void main(String[] args) {

        View view = AppFactory.createView();
        view.start();

    }
}

