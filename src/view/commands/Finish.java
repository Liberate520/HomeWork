package view.commands;

import view.View;

public class Finish extends Command {

    public Finish(View ui) {
        super(ui);
        description = "Завершить работу.";
    }

    @Override
    public void execute() {
        ui.finish();
    }
}
