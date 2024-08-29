package view.commands;

import view.View;

public class Save extends Command {

    public Save(View ui) {
        super(ui);
        description = "Сохранить.";
    }

    @Override
    public void execute() {
        ui.save();
    }
}
