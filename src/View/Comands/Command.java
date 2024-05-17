package View.Comands;
import View.Console;

public class SortByBirthday extends Command{
    private final Console console;

    public SortByBirthday(Console console) {
        super(console);
        this.console = console;
    }

    @Override
    public String description() {
        return "Отсортировать по дате рождения";
    }

    @Override
    public void execute() {
        getConsole().sortByBirthday();
    }
}