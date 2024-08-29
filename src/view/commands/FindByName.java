package view.commands;

import view.View;

public class FindByName extends Command {

    public FindByName(View ui) {
        super(ui);
        description = "Найти человека по имени.";
    }

    @Override
    public void execute() {
        ui.findByName();
    }
}
