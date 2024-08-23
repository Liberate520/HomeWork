package View.Commands;

import View.ConsoleWork;

public class CreateFamilyLinkCommand extends Command {

    public CreateFamilyLinkCommand(ConsoleWork consoleWork) {
        super(consoleWork);
        description = "Создать родственную связь";
    }

    public void execute() {
        consoleWork.addFamilyLink();
    }
}
