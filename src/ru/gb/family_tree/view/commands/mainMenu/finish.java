package ru.gb.family_tree.view.commands.mainMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class finish extends Command {


    public finish(ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().choiseFinish();
        // TODO сделать запуск главного меню повторно тут
    }
}