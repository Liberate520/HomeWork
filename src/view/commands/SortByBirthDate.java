package view.commands;

import view.View;

public class SortByBirthDate extends Command{

    public SortByBirthDate(View ui) {
        super(ui);
        description = "Отсортировать по дате рождения.";
    }

    @Override
    public void execute() {
        ui.sortByBirthDate();
    }
}
