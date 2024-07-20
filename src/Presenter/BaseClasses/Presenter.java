package Presenter.BaseClasses;

import java.util.TreeMap;


public abstract class Presenter {
    protected final TreeMap<String, Command> commandsList = new TreeMap<>();
    protected final String className;

    public Presenter(String className){
        this.className = className;
    }

    public abstract void acceptInput(String userInput);

    protected void execute(String commandName){
        this.commandsList.get(commandName).execute();
    }

    protected void addCommand(Command command) {
        this.commandsList.put(command.getKey(), command);
    }

    public abstract void start();
}
