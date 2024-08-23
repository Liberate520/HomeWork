package View.Commands;

import View.ConsoleWork;

public class AddMember extends Command {

    public AddMember(ConsoleWork consoleWork) {
        super(consoleWork);
        description = "Добавить члена семьи";
    }
    
    public void execute() {
        consoleWork.addMember();
    }
}