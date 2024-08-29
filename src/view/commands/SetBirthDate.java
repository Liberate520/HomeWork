package view.commands;

import view.View;

public class SetBirthDate extends Command{

    public SetBirthDate(View ui) {
        super(ui);
        description = "Установить дату рождения.";
    }

    @Override
    public void execute() {
        ui.setBirthDate();
    }
}
