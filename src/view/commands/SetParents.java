package view.commands;

import view.View;

public class SetParents extends Command{

    public SetParents(View ui) {
        super(ui);
        description = "Установить родителей.";
    }

    @Override
    public void execute() {
        ui.setParents();
    }
}
