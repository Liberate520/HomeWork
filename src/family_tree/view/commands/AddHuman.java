package family_TREE.view.commands;

import family_TREE.view.Console;

public class AddHuman extends Command{
    public AddHuman(Console console){
        super("Добавить человека", console);
    }

    @Override
    public void execute() {
        getConsole().addHuman();
    }
}
