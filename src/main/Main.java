package main;

import presenter.FamilyTreePresenter;
import presenter.TreePresenter;
import storage.DataStorage;
import storage.FileDataStorage;
import view.ConsoleTreeView;

public class Main {
    public static void main(String[] args) {
        DataStorage storage = new FileDataStorage();
        ConsoleTreeView view = new ConsoleTreeView();
        TreePresenter presenter = new FamilyTreePresenter(view, storage);
        view.setPresenter(presenter);
        view.start();
    }
}

