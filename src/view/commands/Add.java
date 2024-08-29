package view.commands;

import view.View;

public class Add extends Command {

    public Add(View ui) {
        super(ui);
        description = "Добавить человека.";
    }

    @Override
    public void execute() {
        ui.add();
    }
}
