package FT.commands;

import FT.Human;
import FT.UI.ConsoleUI;
/*
показать всех детей члена семьи
 */

public class Command_4 implements Commands {
    ConsoleUI consoleUI;

    public Command_4(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        System.out.println(consoleUI.getPresenter().getAllChildren(str));
    }

    @Override
    public String description() {
        return "показать всех детей члена семьи";
    }
}