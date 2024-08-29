package view.commands;

import view.View;

public abstract class Command {
    String description;
    View ui;

    public Command(View ui) {
        this.ui = ui;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
