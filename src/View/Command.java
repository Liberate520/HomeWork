package View;

import Presenter.Presenter;

import java.io.IOException;


public abstract class Command {
    public String commandName;
    public Presenter presenter;

    public Command(String commandName){
        this.commandName = commandName;
        this.presenter = Presenter.getInstance();
    };

    public abstract void execute() throws IOException, ClassNotFoundException;

    public void setCommandName(String newCommandName){
        this.commandName = newCommandName;
    };
    public String getCommandName(){
        return this.commandName;
    };

    @Override
    public String toString() {
        return commandName;
    }
}
