package view.commands;

import view.View;

public class SortByName extends Command{

    public SortByName(View ui) {
        super(ui);
        description = "Отсортировать по именам.";
    }

    @Override
    public void execute() {
        ui.sortByName();
    }
}
