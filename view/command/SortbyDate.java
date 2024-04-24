package homeWork.view.command;

import homeWork.view.Console;

public class SortbyDate extends Command{
    public SortbyDate(Console console) {
        super("Упорядочить по дате рождения", console);
    }

    public void execute(){
        console.sortbyDate();
    }
}
