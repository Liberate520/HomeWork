package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class SetFather extends Command{
    public SetFather(ConsoleUI consoleUI) {
        super("�������� ����", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setFather();
    }
}
