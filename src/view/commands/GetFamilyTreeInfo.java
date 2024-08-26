package view.commands;

import view.ConsoleUI;

public class GetFamilyTreeInfo extends Command{

    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести фамильное древо.";
    }

    @Override
    public void execute() {
        consoleUI.getFamilyTreeInfo();
    }
}
