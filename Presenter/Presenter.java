package Presenter;

import model.Model;
import View.View;
import View.Commands.*;
import View.Menu;

public class Presenter {
    private Model model;
    private View view;
    private Menu menu;

    public Presenter(Model model, View view, Menu menu) {
        this.model = model;
        this.view = view;
        this.menu = menu;
        initializeMenu();
    }

    private void initializeMenu() {
        menu.addCommand(new AddMember(model, view));
        menu.addCommand(new SortByName(model, view));
        menu.addCommand(new SortByAge(model, view));
        menu.addCommand(new ShowFamilyTree(model, view));
        menu.addCommand(new SaveFamilyTree(model, view));
        menu.addCommand(new LoadFamilyTree(model, view));
    }

    public void start() {
        while (true) {
            menu.showMenu();
            int choice = menu.getUserChoice();
            menu.executeCommand(choice);
        }
    }
}