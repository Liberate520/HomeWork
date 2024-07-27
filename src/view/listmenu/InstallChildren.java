package view.listmenu;

import model.builder.Human;
import view.ConsoleUI;

public class InstallChildren extends Command {
    private final Human human;

    public InstallChildren(ConsoleUI consoleUI, Human human) {
        super("Добавить ребёнка", consoleUI);
        this.human = human;
    }

    @Override
    public void execute() {
        getConsoleUI().setChildrenForPerson(human);
    }
}
