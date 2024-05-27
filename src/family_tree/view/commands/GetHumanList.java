package family_TREE.view.commands;

import family_TREE.view.Console;

public class GetHumanList extends Command{
    public GetHumanList(Console console){
        super("Получить список людей", console);
    }

    @Override
    public void execute() {
        getConsole().getHumanList();
    }
}
