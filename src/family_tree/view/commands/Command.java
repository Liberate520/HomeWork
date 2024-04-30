package family_TREE.view.commands;

import family_TREE.view.Console;

public abstract class Command {
    public static Command command;
    private String description;
    private final Console console;

    public Command(String description,Console console) {
        this.description = description;
        this.console = console;
    }

    public String getDescription(){
        return "Получить список людей";
    }

    Console getConsole(){
        return console;
    }
    public void execute(){
        console.getHumanList();
    }
}
