package Family_tree.view.commands;

import ru.gb.Family_tree.view.ConsoleUI;

public class AddHuman extends Command {


    public AddHuman(ConsoleUI consoleUI) {
        super( "Добавить человека", consoleUI);
    }

    @Override
    public void execute(){
         getConsoleUI().add();
    }

}
