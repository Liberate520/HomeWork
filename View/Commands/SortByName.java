package View.Commands;

import model.Model;
import View.View;

public class SortByName extends Command {

    public SortByName(Model model, View view) {
        super(model, view);
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

