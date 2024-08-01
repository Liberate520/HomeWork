package group.model.view.comands;

import group.model.view.ConsoleUI;

public class Finish extends Commands {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){
        consoleUI.finish();
    }

}
