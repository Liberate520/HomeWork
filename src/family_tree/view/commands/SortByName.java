package family_TREE.view.commands;

import family_TREE.view.Console;

public class SortByName extends Command{
    public SortByName(Console console){
        super("Отсортировать по имени", console);
    }

    @Override
    public void execute() {
        getConsole().sortByName();
    }
}
