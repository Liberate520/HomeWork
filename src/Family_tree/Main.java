package Family_tree;

import ru.gb.Family_tree.model.family_tree.Family_tree;
import ru.gb.Family_tree.presenter.Presenter;
import ru.gb.Family_tree.view.ConsoleUI;
import ru.gb.Family_tree.view.View;


public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}