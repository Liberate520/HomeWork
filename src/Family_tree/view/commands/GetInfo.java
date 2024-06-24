package Family_tree.view.commands;

import ru.gb.Family_tree.view.ConsoleUI;

public class GetInfo extends Command {


    public GetInfo(ConsoleUI consoleUI) {
        super( "Получить текущую информацию о древе", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getInfo();
    }

}
