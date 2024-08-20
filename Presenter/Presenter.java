package Presenter;

import model.Model;
import View.View;
import View.Menu;

public class Presenter {
    private Model model;
    private View view;
    private Menu menu;

    public Presenter(Model model, View view, Menu menu) {
        this.model = model;
        this.view = view;
        this.menu = menu; 
    }

    public void start() {
        while (true) {
            menu.showMenu();  
            int choice = view.getUserChoice();
            menu.executeCommand(choice);
        }
    }
}