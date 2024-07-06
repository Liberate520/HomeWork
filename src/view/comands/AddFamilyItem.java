package view.comands;

import view.ConsoleUI;

public class AddFamilyItem extends Command {


    public AddFamilyItem(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить члена семьи");
    }

    @Override
    public void execute() {
        getConsoleUI().addFamilyItem();
    }
}
