package family_TREE.view.commands;

import family_TREE.view.Console;

public class Finish extends Command{
    public Finish(Console console){
        super("Закончить работу", console);
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
