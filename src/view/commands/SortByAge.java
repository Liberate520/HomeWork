package view.commands;

import view.View;

public class SortByAge extends Command{

    public SortByAge(View ui) {
        super(ui);
        description = "Отсортировать по возрасту.";
    }

    @Override
    public void execute() {
        ui.sortByAge();
    }
}
