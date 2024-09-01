package ru.gb.family_tree;

import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.service.FamilyTreeServices;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.Console;


public class Main {
    public static void main(String[] args){
        String filePath = "src/family_tree.out";

        FamilyTreeServices service = new FamilyTreeServices(new FileHandler(filePath));
        Console console = new Console();
        Presenter presenter = new Presenter(console, service);
        console.setPresenter(presenter);

        console.start();
    }
}
