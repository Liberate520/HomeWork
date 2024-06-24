package Family_tree.view.commands;

import ru.gb.Family_tree.view.ConsoleUI;

public class SortName extends Command {


    public SortName(ConsoleUI consoleUI) {
        super( "Отсортировать по имени", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortName();
    }

}
