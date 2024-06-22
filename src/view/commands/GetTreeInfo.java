//package view.commands;
//
////package view.commands;
//
//import view.ConsoleUI;
//
//public class GetTreeInfo extends Command {
//    public GetTreeInfo(ConsoleUI consoleUI) {
//        super(consoleUI);
//        description = "Получить информацию о дереве";
//    }
//
//    @Override
//    public void execute() {
//        consoleUI.getTreeInfo();
//    }
//}
package view.commands;

import view.ConsoleUI;

public class GetTreeInfo implements Command {
    private ConsoleUI consoleUI;

    public GetTreeInfo(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getTreeInfo();
    }
}
