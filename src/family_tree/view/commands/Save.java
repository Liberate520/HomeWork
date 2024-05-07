package family_TREE.view.commands;

import family_TREE.view.Console;

public class Save extends Command{
    public Save(Console console){
        super("Сохранить", console);
    }

    @Override
    public void execute() {
        getConsole().save();
    }
}