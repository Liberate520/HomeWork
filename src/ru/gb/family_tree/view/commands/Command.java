package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public abstract class Command {
    String description;
    View view;

    public Command(View view) {
        this.view = view;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
