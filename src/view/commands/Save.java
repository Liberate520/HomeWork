package view.commands;
import model.writer.FileHandler;
import view.ConsoleUI;

public class Save extends Command {
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "сохранить в файл";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }

}
