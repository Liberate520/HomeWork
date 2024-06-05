package View.Comands;
import View.Console;

public class AddРerson extends Command {
    public AddРerson(Console console) {
        super();
    }

    @Override
    public String description() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        getConsole().addРerson();
    }
}