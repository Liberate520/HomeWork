package view.comand;

import view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выйти из программы";
    }
    public void execute(){
        consoleUI.finish();
    }
}