package homeWork.view.command;

import homeWork.view.Console;

public class SortbyName extends Command{
    public SortbyName(Console console) {
        super("Упорядочить по имени", console);
    }

    public void execute(){
        console.sortbyName();
    }
}
