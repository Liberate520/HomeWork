package view;

import view.commands.Command;

import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(List<Command> commands) {
        this.commands = commands;
    }
}
