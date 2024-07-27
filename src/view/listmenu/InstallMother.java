package view.listmenu;

import model.builder.Human;
import view.ConsoleUI;

public class InstallMother extends Command {
    private final Human human;

    public InstallMother(ConsoleUI consoleUI, Human human) {
        super("Добавить маму", consoleUI);
        this.human = human;
    }

    @Override
    public void execute() {
        getConsoleUI().setMotherForPerson(human);
    }
}