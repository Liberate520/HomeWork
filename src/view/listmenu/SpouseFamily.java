package view.listmenu;

import model.builder.Gender;
import model.builder.Human;
import view.ConsoleUI;

import java.util.List;

public class SpouseFamily extends Command {
    private final Human human;
    private final List<Human> potentialSpouses;

    public SpouseFamily(ConsoleUI consoleUI, Human human, List<Human> potentialSpouses) {
        super("Добавить супруга(у)", consoleUI);
        this.human = human;
        this.potentialSpouses = potentialSpouses;
    }

    @Override
    public void execute() {
        getConsoleUI().setSpouseForPerson(human, potentialSpouses);
    }
}
