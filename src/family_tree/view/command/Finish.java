package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super("��������� ������", consoleUI);
    }


    @Override
    public void execute(){
        getConsoleUI().finish();
    }
}
