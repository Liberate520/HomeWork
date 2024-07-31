package View.Commands;

import model.Model;
import View.View;

public class SortByName implements Command {
    private Model model;
    private View view;

    public SortByName(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        model.sortByName();
        view.showMessage("Семейное дерево отсортировано по имени.");
    }

    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }
}
