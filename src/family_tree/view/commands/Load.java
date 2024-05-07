package family_TREE.view.commands;

import family_TREE.view.Console;

public class Load extends Command{
    public Load(Console console){
        super("Загрузить", console);
    }

    @Override
    public void execute() {
        getConsole().load();
    }
}
