package Presenter.FamilyTreePresenter.Commands;

import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

import java.util.ArrayList;

public class commands extends Command implements Performing {
    private final FamilyTreeView view;
    private final ArrayList<Command> commands;

    public commands(FamilyTreeView view, ArrayList<Command> commands){
        super("commands", "Вывод списка доступных команд");

        this.commands = commands;
        this.view = view;
    }

    @Override
    public void execute() {
        StringBuilder info = new StringBuilder();

        for (int index = 0; index != this.commands.size() - 1; index++){
            info.append(String.format("\tKey: %s", this.commands.get(index).getKey()));
            info.append(String.format("\n\tDescription: %s", this.commands.get(index).getDescription()));
            info.append("\n\n");
        }

        info.append(String.format("\tKey: %s", this.commands.getLast().getKey()));
        info.append(String.format("\n\tDescription: %s", this.commands.getLast().getDescription()));
        info.append("\n");

        this.view.println(info.toString());
    }
}
