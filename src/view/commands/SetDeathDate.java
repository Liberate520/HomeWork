package view.commands;

import view.View;

public class SetDeathDate extends Command{

    public SetDeathDate(View ui) {
        super(ui);
        description = "Установить дату смерти.";
    }

    @Override
    public void execute() {
        ui.setDeathDate();
    }
}
