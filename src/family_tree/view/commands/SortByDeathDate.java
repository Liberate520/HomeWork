package family_TREE.view.commands;

import family_TREE.view.Console;

public class SortByDeathDate extends Command{
    public SortByDeathDate(Console console){
        super("Отсортировать по возрасту", console);
    }

    @Override
    public void execute() {
        getConsole().sortByDeathDate();
    }
}