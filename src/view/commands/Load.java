package view.commands;

import view.View;

public class Load extends Command {

    public Load(View ui) {
        super(ui);
        description = "Загрузить.";
    }

    @Override
    public void execute() {
        ui.load();
    }
}
