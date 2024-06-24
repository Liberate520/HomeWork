package Family_tree.view.commands;

import ru.gb.Family_tree.view.ConsoleUI;

public class SortBirthdate extends Command {


    public SortBirthdate(ConsoleUI consoleUI) {
        super( "Отсортировать по дате рождения", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortBirthdate();
    }

}
