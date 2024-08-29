package view.commands;

import view.View;

public class GetFamilyTreeInfo extends Command {

    public GetFamilyTreeInfo(View ui) {
        super(ui);
        description = "Вывести фамильное древо.";
    }

    @Override
    public void execute() {
        ui.getFamilyTreeInfo();
    }
}
