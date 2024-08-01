package ru.gb2.family_tree7;

import ru.gb2.family_tree7.presenter.FamilyTreePresenter;
import ru.gb2.family_tree7.view.ConsoleFamilyTreeView;

public class Main {
    public static void main(String[] args) {
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);
        presenter.run();
    }
}