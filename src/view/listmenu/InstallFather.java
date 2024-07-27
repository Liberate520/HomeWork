package view.listmenu;

import model.builder.Human;
import view.ConsoleUI;

public class InstallFather extends Command {
    private final Human human;

    public InstallFather(ConsoleUI consoleUI, Human human) {
        super("Добавить папу", consoleUI);
        this.human = human;
    }

    @Override
    public void execute() {
        getConsoleUI().setFatherForPerson(human);
    }
}
