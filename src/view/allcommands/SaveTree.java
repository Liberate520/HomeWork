package view.allcommands;

import view.ConsoleUI;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description="Сохранить древо в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveTree();
    }
}


