package View.Commands;

import model.Model;
import View.View;

public class SortByAge extends Command {

    public SortByAge(Model model, View view) {
        super(model, view);
    }

    @Override
    public void execute() {
        model.sortByAge();
        view.showMessage("Семейное дерево отсортировано по дате рождения.");
    }

    @Override
    public String getDescription() {
        return "Сортировать по дате рождения";
    }
}

