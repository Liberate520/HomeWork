package main;

import presenter.FamilyTreePresenter;
import presenter.TreePresenter;
import service.FamilyTreeService;
import storage.DataLoader;
import storage.DataSaver;
import storage.FileDataLoader;
import storage.FileDataSaver;
import view.ConsoleTreeView;
import view.TreeView;

public class Main {
    public static void main(String[] args) {
        DataLoader dataLoader = new FileDataLoader();
        DataSaver dataSaver = new FileDataSaver();
        FamilyTreeService service = new FamilyTreeService(dataLoader, dataSaver);

        TreeView treeView = new ConsoleTreeView();
        TreePresenter presenter = new FamilyTreePresenter(treeView, service);

        treeView.setPresenter(presenter);
        treeView.start();
    }
}








